package com.kosmo.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GongmoCrawler {

    private CloseableHttpClient clientBuilder;
    private CloseableHttpClient clientSubBuilder;
    private StringBuffer gongmoHtml; 

    
    
    public String getGongmoCrawler() {
    	return gongmoHtml.toString();
    }
    
    public GongmoCrawler() {
    	clientBuilder = HttpClientBuilder.create().build();

	    String url2 = "http://campusmon.jobkorea.co.kr/Contest/List?_Field_Code=A";
        //GongmoCrawler mm = new GongmoCrawler();

        String returnStr = get(url2);

        // Jsoup 파싱
	    Document parseDoc0 = Jsoup.parse(returnStr);
	    Elements elems0 = new Elements();
	    Element elem0 = null;
		String hrefStr = "";

		int loopcnt = 0;

		elems0 = parseDoc0.select("td.tl");
		
		
		gongmoHtml = new StringBuffer();
		gongmoHtml.append("<table class='table table-hover'>");
		gongmoHtml.append("<col style='width: 5%;'></col>");
		gongmoHtml.append("<col style='width: 45%;'></col>");
		gongmoHtml.append("<col style='width: 40%;'></col>");
		gongmoHtml.append("<col style='width: 10%;'></col>");
		gongmoHtml.append("<thead>");
		gongmoHtml.append("<tr>");
		gongmoHtml.append("<th><input type='checkbox' class='checkAll' id='checkAll'></th>");
		gongmoHtml.append("<th style='vertical-align: middle;'>공모전<br>포스터</th>");
		gongmoHtml.append("<th style='vertical-align: middle;'>주최<br>링크</th>");
		gongmoHtml.append("<th style='vertical-align: middle;'>진행기간</th>");
//		gongmoHtml.append("<th>공모요강</th>");
		gongmoHtml.append("</tr>");
		gongmoHtml.append("</thead>");
		gongmoHtml.append("<tbody>");
		
		
		for(Element data : elems0){

			loopcnt++;
			if(loopcnt > 10)
				break;

			hrefStr = data.getElementsByAttribute("href").attr("href");
			String[] tempSeq = hrefStr.split("/");
			String seq = tempSeq[3];
//			System.out.println(seq); // + "," + seq);

			//------------- 상세내용 크롤링 ---------------
			clientSubBuilder = HttpClientBuilder.create().build();
			String url = "http://campusmon.jobkorea.co.kr/Contest/Read/"+seq;
			

	        String returnStr2 = get(url);
	        Document parseDoc = Jsoup.parse(returnStr2);
 			Elements elems = new Elements();
 			Element elem = null;
 			String gtitle = "";
 			elem = parseDoc.select("div.viewInfoTop").get(0).select("h3").get(0);
 			gtitle = elem.text();
//			System.out.println("공모명 가져오기 : " + gtitle + "\n");

			
			elem = parseDoc.select("div.viewInfoTop").select("img[src]").get(0);
			String gposter = elem.toString();
			String[] unit = gposter.split("\"");
			String posterurl = unit[1];
//			System.out.println("poster 링크 가져오기 : " + posterurl + "\n");

			elem = parseDoc.select("ul.tx").get(0).select("li").select("span").get(0);
			String gspon = elem.text();
//			System.out.println("주최 가져오기 : " + gspon + "\n");


			elem = parseDoc.select("div.txWay").get(0).select("dd").select("em").get(0);
			String tempday = elem.text();
			String replaceStr = tempday.replace(".", "-");
			String[] sday = replaceStr.split(" ~ ");
			String[] realSday = sday[0].split("\\(");
			String[] realEday = sday[1].split("\\(");
//			System.out.println("접수기간 가져오기 : " + realSday[0] + "     ~     " + realEday[0] + "\n\n");

			elem = parseDoc.select("div.viewInfoTop").get(0).select("a[href]").get(0);
			String tempUrl = elem.toString();
			String[] tempUrl2 = tempUrl.split("\"");
			String glink = tempUrl2[1];
//			System.out.println("glink : " + glink);
			

			String urlGbody = "http://campusmon.jobkorea.co.kr/Contest/Dtl_Gdln?Cntst_No="+seq;
			String returnGbody = get(urlGbody);
			Document parseDoc2 = Jsoup.parse(returnGbody.toString());
			Element elem2 = null;
			String str2 = "";
			elem2 = parseDoc2.select("body").get(0);
			str2 = elem2.toString();
			String[] unit2 = str2.split("<body>");
			String[] unit3 = unit2[1].split("<script");
//			System.out.println("공모요강 가져오기 : " + unit3[0] + "\n");


			gongmoHtml.append("<tr>");
			gongmoHtml.append("<td style='vertical-align: middle;'><input type='checkbox' class='checkRow' id='"+loopcnt+"' value='"+loopcnt+"'></td>");
			gongmoHtml.append("<td style='vertical-align: middle;'><input type='text' class='form-control' name='gtitle' id='gtitle"+loopcnt+"' value='"+gtitle+"' style='width: 100%;'><br><input type='text' class='form-control' name='gposter' id='gposter"+loopcnt+"' value='"+posterurl+"' style='width: 100%;'></td>");
			gongmoHtml.append("<td style='vertical-align: middle;'><input type='text' class='form-control' name='gspon' id='gspon"+loopcnt+"' value='"+gspon+"'><br><input type='text' class='form-control' name='glink' id='glink"+loopcnt+"' value='"+glink+"' style='width: 100%;'></td>");
			gongmoHtml.append("<td style='text-align: center; vertical-align: middle;'><input type='date' class='form-control' name='gsday' id='gsday"+loopcnt+"' value='"+realSday[0]+"'><br><input type='date' class='form-control' name='geday' id='geday"+loopcnt+"' value='"+realEday[0]+"'></td>");
//			gongmoHtml.append("<td style='width: 100%; vertical-align: middle; text-overflow: ellipsis; overflow: hidden; white-space: nowrap;'>"+unit3[0]+"</td>");
			gongmoHtml.append("<input type='hidden' name='gbody' id='gbody"+loopcnt+"' value='"+unit3[0]+"'>");
			gongmoHtml.append("</tr>");
			
			try {
	        	clientSubBuilder.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }


			//------------- 상세내용 크롤링 ---------------

		}
		
		gongmoHtml.append("</tbody>");
		gongmoHtml.append("</table>");
		
        try {
        	clientBuilder.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    /**
     * GET
     *
     * @param url       요청할 url
     * @param params    파라미터 Map
     * @param encoding  파라미터 Encoding Type
     * @return 응답본문 문자열
     */
    public String get(String url) {

        try {
            HttpGet get = new HttpGet(url);
//            System.out.println("================================");
//            System.out.println("GET : " + get.getURI());
//            System.out.println("================================");
            ResponseHandler<String> rh = new BasicResponseHandler();
            String execute = clientBuilder.execute(get, rh);
            return execute;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //            client.close();
        }

        return "error";
    }

    
//    public static void main(String[] args) {
//    	GongmoCrawler gc = new GongmoCrawler();
//    	gc.getGongmoCrawler();
//    }
}
