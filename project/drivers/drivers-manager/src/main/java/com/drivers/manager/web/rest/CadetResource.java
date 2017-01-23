package com.drivers.manager.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.drivers.entity.Cadet;
import com.drivers.entity.Coach;
import com.drivers.manager.security.SecurityUtils;
import com.drivers.router.repository.CadetRepository;
import com.drivers.router.repository.CoachRepository;
import com.drivers.router.repository.WxMerchantRepository;
import com.drivers.router.service.CadetService;
import com.drivers.router.web.request.CadetReq;
import com.drivers.router.web.request.base.Request;
import com.drivers.router.web.request.common.SingleFieldUpdateReq;
import com.drivers.router.web.response.CadetResp;
import com.drivers.router.web.response.base.PagerResponse;
import com.drivers.router.web.response.base.Response;
import com.drivers.router.web.response.base.StatusCode;
import com.drivers.router.web.rest.base.BaseResource;
import com.medal.common.poi.PoiExcelHelper;
import com.medal.common.utils.StringUtil;
import com.medal.weixin.sdk.client.TemplateMessageClient;
import com.medal.weixin.sdk.pojo.TemplateData;
import com.medal.weixin.sdk.pojo.TemplateMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.javasimon.aop.Monitored;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springside.modules.mapper.JsonMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by xhuji on 2016/8/28.
 */
@RestController
@RequestMapping("/api/cadets")
@Slf4j
public class CadetResource extends BaseResource {

    private static final String upload_dir = "E:\\code\\idea_workspace\\medal\\project\\drivers\\drivers-manager\\src\\main\\webapp\\upload\\cadet\\";
    @Autowired
    private CadetService cadetService;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @RequestMapping(value = "/create",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Long> createSysManager(@RequestBody @Validated Request<Cadet> request, BindingResult result) throws Exception{
        Response<Long> response = new Response<>();
        response.setStatusCode(StatusCode.OK);
        if(!resolvedValidate(response,result)){
            return response;
        }

        if (request.getContent().getId() != null){
            response.setStatusCode(StatusCode.Business_TS_MEGER);
            response.setMessage("ID不能有值");
            return response;
        }
        request.getContent().setDataCreator(SecurityUtils.getCurrentUserLogin());
        request.getContent().setDataUpdater(SecurityUtils.getCurrentUserLogin());
        cadetService.save(request,response);
        return response;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Integer> deleteCoach(@RequestBody @Validated Request<Long> request, BindingResult result) throws Exception{
        PagerResponse<Integer> response = new PagerResponse<>();
        response.setStatusCode(StatusCode.OK);
        if(!resolvedValidate(response,result)){
            return response;
        }
        cadetService.invalid(request,response,SecurityUtils.getCurrentUserLogin());
        return response;
    }
    @RequestMapping(value = "/batchDelete", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Integer> batchDeleteCoach(@RequestBody @Validated Request<List<Long>> request, BindingResult result) throws Exception{
        Response<Integer> response = new Response<>();
        response.setStatusCode(StatusCode.OK);
        if(!resolvedValidate(response,result)){
            return response;
        }
        cadetService.batchInvalid(request,response,SecurityUtils.getCurrentUserLogin());
        return response;
    }
    /**
     * 单个字段更新
     * @param request
     * @param result
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/singleFieldUpdate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Integer> singleFieldUpdate(@RequestBody @Validated Request<SingleFieldUpdateReq> request, BindingResult result ) throws Exception{
        Response<Integer> response = new Response<>();
        response.setStatusCode(StatusCode.OK);
        if(!resolvedValidate(response,result)){
            return response;
        }
        request.getContent().setDataUpdater(SecurityUtils.getCurrentUserLogin());
        cadetService.siglnFieldUpdate(request,response);
        return response;
    }

    /**
     * 绑定微信账号
     * @param request
     * @param result
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/bindWeixin",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Integer> bindWeixin(@RequestBody @Validated Request<Cadet> request, BindingResult result) throws Exception{
        Response<Integer> response = new Response<>();
        response.setStatusCode(StatusCode.OK);
        if(!resolvedValidate(response,result)){
            return response;
        }
        if (request.getContent().getId() == null){
            response.setStatusCode(StatusCode.Business_TS_MEGER);
            response.setMessage("ID不能为空");
            return response;
        }
        request.getContent().setDataUpdater(SecurityUtils.getCurrentUserLogin());
        cadetService.bindWeixin(request,response);
        return response;
    }
    /**
     * 解绑微信账号
     * @param request
     * @param result
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/unbindWeixin",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Integer> unbindWeixin(@RequestBody @Validated Request<Cadet> request, BindingResult result) throws Exception{
        Response<Integer> response = new Response<>();
        response.setStatusCode(StatusCode.OK);
        if(!resolvedValidate(response,result)){
            return response;
        }
        if (request.getContent().getId() == null){
            response.setStatusCode(StatusCode.Business_TS_MEGER);
            response.setMessage("ID不能为空");
            return response;
        }
        request.getContent().setDataUpdater(SecurityUtils.getCurrentUserLogin());
        cadetService.unbindWeixin(request,response);
        return response;
    }
    @Autowired
    private CadetRepository cadetRepository;
    @Autowired
    private CoachRepository coachRepository;
    @Autowired
    private JsonMapper jsonMapper;
    @Autowired
    private WxMerchantRepository wxMerchantRepository;
    /**
     * 关联教练
     * @param request
     * @param result
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/relateCoach",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Integer> relateCoach(@RequestBody @Validated Request<Cadet> request, BindingResult result) throws Exception{
        Response<Integer> response = new Response<>();
        response.setStatusCode(StatusCode.OK);
        if(!resolvedValidate(response,result)){
            return response;
        }
        if (request.getContent().getId() == null){
            response.setStatusCode(StatusCode.Business_TS_MEGER);
            response.setMessage("ID不能为空");
            return response;
        }
        request.getContent().setDataUpdater(SecurityUtils.getCurrentUserLogin());
        cadetService.relateCoach(request,response);

        String accessToken = wxMerchantRepository.findAccessToken(1L);

        Cadet cadet = cadetRepository.findById(request.getContent().getId());
        Coach coach = coachRepository.findById(request.getContent().getCoachId());
        //推送教练信息给用户
        String cadetOpenid = cadet.getWxOpenid();
        if (StringUtil.isNotBlank(cadetOpenid)){
            Map<String,TemplateData> userMap = new HashedMap(5);
            userMap.put("first",new TemplateData("尊敬的" + cadet.getName() + "：您好！"));
            userMap.put("keyword1",new TemplateData(coach.getName()));
            userMap.put("keyword2",new TemplateData(coach.getName()));
            userMap.put("keyword3",new TemplateData(ZonedDateTime.now().format(formatter)));
            userMap.put("remark",new TemplateData("你的新客服将在1周内主动联系你，请保持联系。"));
            TemplateMessage templateMessage = new TemplateMessage();
            templateMessage.setTemplateId("eFjYJk0tJnbo6-xz67vRtwaw4DbwlxWVhkPcN9Y58wk");
            templateMessage.setTouser(cadetOpenid);
            templateMessage.setUrl("");
            templateMessage.setData(userMap);
            String json  = jsonMapper.toJson(templateMessage);
            TemplateMessageClient.sendTemplateMessage(accessToken,json);
        }
        //推送用户信息给教练
        String coachOpenid = coach.getWxOpenid();
        if (StringUtil.isNotBlank(cadetOpenid)){
            Map<String,TemplateData> userMap = new HashedMap(5);
            userMap.put("first",new TemplateData("尊敬的" + coach.getName() + "教练员：您好！"));
            userMap.put("keyword1",new TemplateData(cadet.getName()));
            userMap.put("keyword2",new TemplateData(ZonedDateTime.now().format(formatter)));
            userMap.put("keyword3",new TemplateData("周一至周五"));
            userMap.put("remark",new TemplateData("已为您分配以上学员,请及时确认,谢谢。"));
            TemplateMessage templateMessage = new TemplateMessage();
            templateMessage.setTemplateId("sBRUJNwsKgwlbHotBjT6mwwFQX2qtRrev2PbuYJ7B7g");
            templateMessage.setTouser(coachOpenid);
            templateMessage.setUrl("");
            templateMessage.setData(userMap);
            String json  = jsonMapper.toJson(templateMessage);
            TemplateMessageClient.sendTemplateMessage(accessToken,json);
        }
        return response;
    }
    /**
     *
     * @param request
     * @param result
     * @return
     */
    @RequestMapping(value = "_search/cadets", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public PagerResponse<CadetResp> getByPage(@Validated CadetReq request, BindingResult result){
        PagerResponse<CadetResp> response = new PagerResponse<>();
        response.setStatusCode(StatusCode.OK);
        if(!resolvedValidate(response,result)){
            return response;
        }
        cadetService.findAllBySearch(request,response);
        return response;
    }

    @Timed
    @Monitored
    @RequestMapping(value="/upload", method = RequestMethod.POST)
    public void upload(@RequestParam("file")MultipartFile file) throws Exception{
        String fileName = file.getOriginalFilename();

        File copyFile = new File( upload_dir + fileName);
        inputstreamtofile(file.getInputStream(), copyFile);
        saveExcelData(upload_dir + fileName);
    }

    @Async
    @Transactional
    public  void saveExcelData(String filename){
        PoiExcelHelper helper = PoiExcelHelper.getPoiExcelHelper(filename);
        List<String> databaseSheetName = helper.getSheetList(filename,new ArrayList<>());
        List<List<String>> databaseExcelContent = new ArrayList<List<String>>();
        for (int i = 0; i < databaseSheetName.size(); i++) {
            databaseExcelContent.addAll(
                    helper.readExcel(filename, i, "2-",
                            new String[]{"b","c","d","e","f","g","h","i","j"}) ) ;
        }

        List<Cadet> cadets = new ArrayList<>();
        List<Coach> coaches = new ArrayList<>();
        for(List<String> content : databaseExcelContent){
            Cadet cadet = new Cadet();
            cadet.setName(content.get(0));
            String sexStr = content.get(1);
            if (StringUtils.isBlank(sexStr)){
                cadet.setSex(0);
            }else if ("男".equals(sexStr)){
                cadet.setSex(1);
            }else if ("女".equals(sexStr)){
                cadet.setSex(2);
            }else {
                cadet.setSex(3);
            }
            cadet.setEnrolDatetime(ZonedDateTime.now());
            cadet.setAddr(content.get(3));
            cadet.setIdcardNum(content.get(4));
            cadet.setModel(content.get(5));
            cadet.setMobile(content.get(6));
            cadet.setDataCreator("export");
            cadet.setDataUpdater("export");
            cadets.add(cadet);

        }


        Request<List<Cadet>> request = new Request<>();
        request.setContent(cadets);
        Response<Integer> response = new Response<>();
        cadetService.batchSave(request,response);
        System.out.printf("response");
    }
    public void inputstreamtofile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

