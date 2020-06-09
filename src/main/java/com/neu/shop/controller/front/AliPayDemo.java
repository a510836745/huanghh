package com.neu.shop.controller.front;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.util.Map;

public class AliPayDemo {
    public static void jumpToAliPay(HttpServletRequest request, HttpServletResponse response, Map params) throws Exception {
        AlipayClient aliPayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do",
                "2016101900723941",
                "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCsLAfIecRKo/glh+Exy+XtcaCcX/oLZPKPv/L8/0l5PV60bvch7PjBqxf7JEFY57+UouJEwThupG5snfRitHQXWBA8nC8EwYilJQibC1GkAPFL9SOF9c1dQSaAC+7vl6MI4L5kOK8dMTUa5GRchwKRR7vuU5QsMHym+s3fsrTIc+Wd2ju2X47FPEbC9391Phdi5YYzzvPe3bEO8ufWT6vt35zaoSgdnRXqoh58Pfrq9QzoQ2Tj/FUnxxLYNEe6qX4bADsnHSqltEaOfyIs0mfUiJdqHyiYKV7tPtTv8pfU4LZvuVdrdf/XgrI1aoeeUuiUnXiXoAu9IKk7YhasbdLZAgMBAAECggEBAJ8ZfQO7yjEzPm7oFqhehBWcJ8/5POXkneVKem9iNPItTOOtmv+lrOXChkGUajKOzVG8Bx2D8/MCTexfNmMz4AdmYHKx3R0m/m+lPkOP/RxxpokLeY0j7Gddegdff6e113mvvSB95Qwz2aAFJ9z9AdlgkYCViVogYEApia9Kw5ZrRsemdMkStjnUMaSmmR3qKEDy3zMs8TnLQXMVYTl3Hc7VaIc2hmCsp1CG1ENjzl1aBejsSNv7lzX066D5bG67xeYRxbnsrQSQddoJvSZ1C4RtYXY6axtoprYA49izYu9EphjDE2HXcFWYPmIvVKEWyb/ieP1zfRWWdZxxGmIH2tECgYEA1w57BLh9chleh81nJdX9+Z3vldmHQK6hgZycIzHRwKz2m+gnGsdtxLAf1OyH2LQpoja9PR2XB5AcOue3emVJN7sH5dEGdHn02brVBF7mug1SN8I9ccHE9tXIxEsxtq1EdgFQQytbiiYFyS6ePDLDyi9n08xFIgkpw8mn1kp4wi0CgYEAzPNsVYJsV7A9UL7fQC0+RcU30GUvfUoLQ3pGJU0RoqPQ4dDcv8jfDnxFHgRDDyYiP+gTEoP7LgsACxeubVFIiFgmtuQ92djSZiQ/jsyfP3oy0bBYTicrcgKOMKC7gQ5rGNARxWXLFxTNXZV/xpFW6T2LmmvYVHjKZF5teGzwOt0CgYEAhztg2jAVGjmfuu/L6/vrkBrjfKxkI6Vsg+9yM6NxTaK2FIXgiTNc8DD8Y001g2yPPaUETLkdrrDNP7FULBAjAXuH1NkjIP1LndqhdvUiS15zFAL91lnNvJXkgKL0KPY9taLP0N0j2/Ra8Q5yjFIz0iELPiEWW/e9HpPhCZyc4SUCgYBpC2K9OQm6r/PdTNc0F3xRWlHPF+2NM8QuI5+MQsIFMB1BgEGEcroQvJTYW6rbOtpXEuWjmc3FvZGaHdsi4IRijXvaRYWGAGFmRLHmyO3eJQ2i99VqyRy1ZKXoOpmf/fnaT9qr6A59mAXiL1u8NIXtKcRBs4C/WuGxK8zD6mH+aQKBgQCmS4E/KUZioay0Tknw+LRjvuQfd3A9cQT/sFwAg3s0Wl0HyHgz7dh5zTrsAIh0DPu4Sg3xW72Wopc5D8kqhjNJmlqGEo6uJu93vVipy0efuZ9q2jIuzuWh0Xr0sLm+GqI4mvg+UbnaNGtlsIE/w63xapem6qzwnzdiW4IaI8T+vw==",                "JSON",
                "utf-8",
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjMu2RWUwCmbj6LJoZMkOjFJFAON2g3NITdN2jjrW8pV57I4qLvz8HJNp5fzCjOOKM5SlGLsdiFU2BAXIgZUIjoPyOPl1nygaDiYKd2ZPn9MDPLjgdDNm5d4UE14fw0j0P/+mfM9xWJrPyvbnl0rIpXnxNnW06OvLE/tTo+6KMjnRQCXUu47uIbtsvsX63x/tDzZjCmOmpNeKZK83dWwhgMuVSr6Xw9qbyaCxP5WLA0+Jly82P075H9w+Yu5nCOPehDXSTv3gDJq9rhUVbg9WmsWUuCeEh5i4tNzjrdlBB+LbdpwySRbINdEg8crTHqUBiSp2DU04CRb0tApMy7xnFQIDAQAB",
                "RSA2");
        String orderId = (String) params.get("orderId");
        String newPrice = (String) params.get("newPrice");
        String itemName = (String) params.get("itemName");

        orderId = URLDecoder.decode(orderId, "UTF-8");
        newPrice = URLDecoder.decode(newPrice, "UTF-8");
        itemName = URLDecoder.decode(itemName, "UTF-8");

        AlipayTradePagePayRequest alipayTradePagePayRequest = new AlipayTradePagePayRequest();
        alipayTradePagePayRequest.setReturnUrl("http://localhost:8080/shop/info/list");
        alipayTradePagePayRequest.setBizContent("{" +
                "\"out_trade_no\":\""+ orderId + "\"," +
                "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                "\"total_amount\":\""+ newPrice +"\"," +
                "\"subject\":\""+ itemName +
                "\"}");//填充业务参数

        String form = "";
        form = aliPayClient.pageExecute(alipayTradePagePayRequest).getBody();
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(form);//直接将完整的表单html输出到页面
        response.getWriter().close();

    }

}
