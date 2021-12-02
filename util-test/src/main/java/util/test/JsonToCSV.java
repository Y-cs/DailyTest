package util.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/10/9 10:25
 * @Description:
 **/
public class JsonToCSV {

    private String readFile() throws IOException {
        File file = new File("D:\\Self\\DailyTest\\util-test\\aaa.json");
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = new byte[1024];
        StringBuilder sb = new StringBuilder();
        int length = 0;
        while ((length = fileInputStream.read(bytes)) != -1) {
            sb.append(new String(bytes, 0, length));
        }
        return sb.toString();
    }

    private boolean writeFile(String cvs) throws IOException {
        File file = new File("D:\\Self\\DailyTest\\util-test\\aaa.cvs");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(cvs);
        fileWriter.flush();
        fileWriter.close();
        return true;
    }

    public static void main(String[] args) throws IOException {
        JsonToCSV jsonToCSV = new JsonToCSV();
        String s = jsonToCSV.readFile();
        JSONArray jsonArray = JSON.parseArray(s);

        //记录所有的Key
//        Set<String> keySet = new HashSet<>();
//        for (int i = 0; i < jsonArray.size(); i++) {
//            JSONObject jsonObject = jsonArray.getJSONObject(i);
//            keySet.addAll(jsonObject.keySet());
//        }
        //转成list
        List<String> keyList = Arrays.stream("TESTNO,JYLSH,JYXH,JYRQ,CLXH,CLPP,CLSBDH,ODOMETER,LICENSETYPE,HPHM,PL,RLZL,DRIVEMODE,GEAR,ENGINESPEED,JCFS,OBDZSQ,OBDZSQBJ,OBDTX,OBDGZXX,OBDJXZT,OBDMIL,OBDJCJG,CLJXZK,PQWRKZZZ,CSYB,CLSYMY,QZXTF,RYZFKZ,JXGZ,CLJPQ,CLYTXL,LTQY,LTGQ,KTNF,SEPCIAL,GKJC,WJJG,IDLEREV,SMOKEK3,SMOKEK2,SMOKEK1,SMOKEAVG,RATEREVTEST,MAXPOWERTEST,KL00,K80,K80NOX,LAMBDA,LOWIDLECO,LOWIDLECOLIMIT,LOWIDLEHC,LOWIDLEHCLIMIT,HIGHIDLECO,HIGHIDLECOLIMIT,HIGHIDLEHC,HIGHIDLELHCLIMIT,LAMBDAUP,LAMBDADOWN,HCTEST,COTEST,NOXTEST,JUDGE"
                .split(",")).map(String::trim).map(String::toLowerCase).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        sb.append(String.join(",", keyList)).append("\n");
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            List<String> valueList = new ArrayList<>();
            for (String s1 : keyList) {
                Object o = jsonObject.get(s1);
                if (o != null) {
                    valueList.add(String.valueOf(o));
                } else {
                    valueList.add(null);
                }
            }
            StringBuilder sb1 = new StringBuilder();
            valueList.forEach(v -> {
                if (v != null) {
                    sb1.append("'").append(v).append("'");
                }
                sb1.append(",");
            });
            sb1.deleteCharAt(sb1.length() - 1);
            sb.append(sb1).append("\n");
        }
        System.out.println(sb);
        jsonToCSV.writeFile(sb.toString());
    }

}
