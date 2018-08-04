package com.wip.utils;

import com.github.pagehelper.PageInfo;
import com.vdurmont.emoji.EmojiParser;
import com.wip.constant.WebConst;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


/**
 * 公共函数
 */
@Component
public class Commons {


    /**
     * 获取随机数数
     * @param max
     * @param str
     * @return
     */
    public static String random(int max, String str) {
        return UUID.random(1,max) + str;
    }

    public static String random(Long seed, int max, String str) {
        if (seed == null) {
            return random(max, str);
        }
        Random random = new Random(seed);
        return random.nextInt(max) +str;
    }

    /**
     * 生成指定范围的随机整数
     * @param member
     * @return
     */
    public static String randomInt(int member,String suf) {
        Random random = new Random();
        return random.nextInt(member) + member + suf;
    }

    /**
     * 返回gitHub头像地址
     * @param email     邮箱
     * @return  头像链接地址
     */
    public static String gravatar(String email) {
        String avatarUrl = "https://github.com/identicons/";
        if (StringUtils.isBlank(email)) {
            email = "864655735@qq.com";
        }
        String hash = TaleUtils.MD5encode(email.trim().toLowerCase());
        return avatarUrl + hash + ".png";
    }

    /**
     * 格式化unix时间戳为日期
     * @param unixTime
     * @param patten
     * @return
     */
    public static String fmtdate(Integer unixTime, String patten) {
        if (null != unixTime && StringUtils.isNotBlank(patten)) {
            return DateKit.formatDateByUnixTime(unixTime,patten);
        }
        return "";
    }

    /**
     * 返回blog文章地址
     * @param cid
     * @return
     */
    public static String blogPermalink(Integer cid) {
        return site_url("/blog/article/" + cid.toString());
    }

    /**
     * 网站链接
     * @return
     */
    public static String site_url() {
        return site_url("");
    }

    /**
     * 返回网站链接下的全址
     * @param sub   后面追加的地址
     * @return
     */
    public static String site_url(String sub) {
        return site_option("site_url") + sub;
    }

    /**
     * 获取网站备案信息
     * @return
     */
    public static String site_record() {
        return site_option("site_record");
    }

    /**
     * 网站配置项
     * @param key
     * @return
     */
    public static String site_option(String key) {
        return site_option(key, "");
    }

    /**
     * 网站配置项
     * @param key           键名
     * @param defaultValue  默认值
     * @return
     */
    public static String site_option(String key, String defaultValue) {
        if (StringUtils.isBlank(key)) {
            return "";
        }
        String str = WebConst.initConfig.get(key);
        if (StringUtils.isNotBlank(str)) {
            return str;
        } else {
            return defaultValue;
        }
    }

    /**
     * 字符串截取
     * @param str   截取的字符串
     * @param len   截取的长度
     * @return      截取之后字符串
     */
    public static String subStr(String str, Integer len) {
        if (null == len) {
            len = 100;
        }
        String tempStr = null;
        if (str.length() > len) {
            tempStr = str.substring(0,len);
            return tempStr + "...";
        }
        return str;
    }

    /**
     * 截取字符串
     *
     * @param str
     * @param len
     * @return
     */
    public static String substr(String str, int len) {
        if (str.length() > len) {
            return str.substring(0, len);
        }
        return str;
    }

    /**
     * 显示文章内容，转换markdown为HTML
     * @param value
     * @return
     */
    public static String article(String value) {
        if (StringUtils.isNotBlank(value)) {
            value = value.replace("<!--more-->", "\r\n");
            value = value.replace("<!-- more -->", "\r\n");
            return TaleUtils.mdToHtml(value);
        }
        return "";
    }

    /**
     * An :grinning:awesome :smiley:string &#128516;with a few :wink:emojis!
     * <p>
     * 这种格式的字符转换为emoji表情
     *
     * @param value
     * @return
     */
    public static String emoji(String value) {
        return EmojiParser.parseToUnicode(value);
    }


    /**
     * 获取社交的链接地址
     * @return
     */
    public static Map<String, String> social() {
        final String prefix = "social_";
        Map<String, String> map = new HashMap<>();
        map.put("csdn", WebConst.initConfig.get(prefix + "csdn"));
        map.put("jianshu", WebConst.initConfig.get(prefix + "jianshu"));
        map.put("resume", WebConst.initConfig.get(prefix + "resume"));
        map.put("weibo", WebConst.initConfig.get(prefix + "weibo"));
        map.put("zhihu", WebConst.initConfig.get(prefix + "zhihu"));
        map.put("github", WebConst.initConfig.get(prefix + "github"));
        map.put("twitter", WebConst.initConfig.get(prefix + "twitter"));
        return map;
    }

    /**
     * 判断分页中是否有数据
     * @param pageInfo
     * @return
     */
    public static boolean is_empty(PageInfo pageInfo) {
        return pageInfo == null || (pageInfo.getList() == null) || (pageInfo.getList().size() == 0);
    }



}
