package springboot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author ljh
 * created on 2019/8/8 19:39
 */
@Controller
@RequestMapping("/weather")
public class PjaxController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PjaxController.class);

    @RequestMapping(value = "/{city}", method = RequestMethod.GET)
    public String index(@PathVariable String city, HttpServletRequest req, Model model) {
        //pjax 请求
        if (null != req.getHeader("X-PJAX")) {
            LOGGER.info("pjax request");
            return String.format("forward:/weather/pjax/%s", city);
        }
        LOGGER.info("normal request");
        model.addAttribute("weather", getCityWeather(city));
        model.addAttribute("city", city);
        //普通请求
        return "freemarker/pjax/weather";
    }

    @RequestMapping(value = "/pjax/{city}", method = RequestMethod.GET)
    @ResponseBody
    public String testPjax(@PathVariable String city) {
        return getCityWeather(city);
    }

    private static final String WEATHER_API = "http://wthrcdn.etouch.cn/weather_mini?city=%s";

    private static final String TEXTAREA = "<textarea>%s</textarea>";

    private static final String ERROR_MSG = "网络异常";

    /**
     * 获取城市天气
     */
    private static String getCityWeather(String city) {

        String result;
        try {
            CloseableHttpClient client = HttpClients.createDefault();

            HttpGet get = new HttpGet(String.format(WEATHER_API, city));
            RequestConfig conf = RequestConfig.custom().setConnectTimeout(2000).build();
            get.setConfig(conf);

            HttpResponse response = client.execute(get);
            String isoBody = EntityUtils.toString(response.getEntity());
            client.close();

            String utfBody = new String(isoBody.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
            JSONObject json = JSON.parseObject(utfBody).getJSONObject("data");

            result = String.format(TEXTAREA, JSON.toJSONString(json, true));
        } catch (IOException e) {
            result = ERROR_MSG;
        }

        return result;
    }

}
