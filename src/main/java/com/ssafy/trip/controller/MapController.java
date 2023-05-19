package com.ssafy.trip.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;

@RestController
@RequestMapping("/map")
@Slf4j
public class MapController {

    /**
     * 경위도 정보로 주소를 불러오는 메소드
     * @throws UnsupportedEncodingException
     */
    @GetMapping("/{keyWord}")
    public ResponseEntity<String> keyWordToAddr(@PathVariable String keyWord) throws UnsupportedEncodingException {
        System.out.println(keyWord);
        String url = "https://dapi.kakao.com/v2/local/search/keyword.json?page=1&size=15&sort=accuracy&query="
                + URLEncoder.encode(keyWord, "UTF-8");
        String data = "";
        try{
            data = getJSONData(url);
            log.info("data {}", data);
        }catch(Exception e){
            System.out.println("주소 api 요청 에러");
            e.printStackTrace();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        return new ResponseEntity<String>(data, headers,HttpStatus.OK);
    }

    /**
     * REST API로 통신하여 받은 JSON형태의 데이터를 String으로 받아오는 메소드
     */
    private String getJSONData(String apiUrl) throws Exception {
        HttpURLConnection conn = null;
        StringBuffer response = new StringBuffer();

        //인증키 - KakaoAK하고 한 칸 띄워주셔야해요!
        String apiKey = "18110217fe110646452c694fa334a817";

        String auth = "KakaoAK " + apiKey;
        //URL 설정
        URL url = new URL(apiUrl);
        conn = (HttpURLConnection) url.openConnection();

        //Request 형식 설정
        conn.setRequestMethod("GET");
        conn.setRequestProperty("X-Requested-With", "curl");
        conn.setRequestProperty("Authorization", auth);


        System.out.println(conn);
        //request에 JSON data 준비
        conn.setDoOutput(true);

        //보내고 결과값 받기
        int responseCode = conn.getResponseCode();
        if (responseCode == 400) {
            System.out.println("400:: 해당 명령을 실행할 수 없음");
        } else if (responseCode == 401) {
            System.out.println("401:: Authorization가 잘못됨");
        } else if (responseCode == 500) {
            System.out.println("500:: 서버 에러, 문의 필요");
        } else { // 성공 후 응답 JSON 데이터받기

            Charset charset = Charset.forName("UTF-8");
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));

            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
        }

        return response.toString();
    }
}
