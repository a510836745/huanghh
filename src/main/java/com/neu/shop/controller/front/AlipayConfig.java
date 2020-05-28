package com.neu.shop.controller.front;

import java.io.FileWriter;
import java.io.IOException;
public class AlipayConfig  {

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id ="2016101900723941";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCRgUP3BskJ5+uWg9R+CCRHo9iGrCgoah1LDMdjKV6x7dc8yyXUg/QsGM/arBLS4QX/3cfc5oCGmY/joeir+EQZv4n17StpiuSs8iC6SOm7Aerze1SQeOztIazDGN/uyY3I9vPGee1QPDns77M+Lv39tgF+24VL4+tBEkqC5OQYWx6DyxkmU6HCuqNyiIx1fJ+vVsUp5qHOae1/Pv9w1WRDZgcpujjZ2MNG6T0g55CzzavmLb4xUQFdCNtreurvPsvaxkWO85mRXHy15cj/8c69O76ahNdvBVSidfBqfhImYxBTcmVgcl5TuOs0CYijzu6Vk3cAHpsLrA7LjSGU2IL/AgMBAAECggEALU/dE3uIdc5Efm31aX4tliW/E0lfhB5vmuSS3x2OAMj5g1QcJs8k5eqgKA/4GLW8wY6WZANgOQpvVcshAxTgWEhetTgzkb2QMw+AA6MbLoKNYV+h2Q/fcIVRILyJV/pqbhABoGht79OhklifMBlAPZdFZfUE0Lpck7oXfCW9ppuZIqoHAWJWOY1+tCOtC0LUkk+KIm0u8spjENZ1lkP8S9uhzdU8+l/Fa7Ot7A2mkzjUfMl1k6BY1aIs6yI2kVic88Z6HT99iSNNR0GKikC3AZTjV+K28n/bAhr64Ut/dtOa9zdlGQqM3jaGCLFdgXWfQqKmHaHLASFMhQpS2WKkcQKBgQDPd0Nkqxu+a6fXCLyKSM92FMnddIJs9/jyjLrDodDiiEDT0dHptDpohPXC6ix5pdzRO0udXrV5IW+4SoprzNP20FeXn0atjyhu53h8ZKVXPgPXjYdS2rG1pUC15nT37cmEOwM0Ghm7LsQedtLhI6nOxRjtlkXd8CCBKaFkkZqqKQKBgQCzi0estjS+mgWDADawRC86X2GjFWUxUDJdb5srmx42v3+xiZ3kGw9i7hchdZ3eTy/dHki3gapXGafH9W/d7lwNXmFo6bJ7PBsplUsrxTdAo/wSMM0dWzsuErhbvXE90MBcAYaBwsgzPzRxO07ixU7lyPQmJAsUjJiD21wENpA45wKBgD1x4yHjk5n4JIOJcN275sXgLlFKen5vium7SG08dbNCC4EwuWzwFgRyrJ8H4Bg/SYEmgKShMjon7wC0Av8ecQC+f9LGN5abuavvHj4pSNbn5RdoMVYWs19LDDlTgf0UDgT9vVsnB8vqc+dZ5ecMOvSkZ1emlBbBUb8vZz9z6EzRAoGBAIzwyuUDa0gsNCNv6X5ZKBHUihqxUuxxHfhHAjIq5H7puN2vP+iubVeluzai07iNxO75NPAIs6UIGLNZMeWvlUdRTXpD6b3foxrzfTzw5byyfc/xyzI+SaiTPXGWtuxlkHspH2OBehLwjMROYFCXvqWXKEFAjgoljBwF+Ke+BV0FAoGAHGShv5eyEutefRwznkG0KxJ78JvhRqoigNqU8l4ZIfNJmUtuaYtcYV82kB4QchSR5j29Gcct7qByiWYVbR+ixxjy5pm1DUDHRb4VQE5SnInDDtpzf6W4Fw0xgn5vJiYrQ5rF0BjNmdzIxzPWA388GeyOSbANN+x1ziZqzJIZuso=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkYFD9wbJCefrloPUfggkR6PYhqwoKGodSwzHYylese3XPMsl1IP0LBjP2qwS0uEF/93H3OaAhpmP46Hoq/hEGb+J9e0raYrkrPIgukjpuwHq83tUkHjs7SGswxjf7smNyPbzxnntUDw57O+zPi79/bYBftuFS+PrQRJKguTkGFseg8sZJlOhwrqjcoiMdXyfr1bFKeahzmntfz7/cNVkQ2YHKbo42djDRuk9IOeQs82r5i2+MVEBXQjba3rq7z7L2sZFjvOZkVx8teXI//HOvTu+moTXbwVUonXwan4SJmMQU3JlYHJeU7jrNAmIo87ulZN3AB6bC6wOy40hlNiC/wIDAQAB";

    // 服务器异步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/notifyUrl.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8080/returnUrl.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    //沙箱网关
    public static String gatewayUrl ="https://openapi.alipaydev.com/gateway.do";

    // 仅支持JSON
    public static String format = "JSON";


}
