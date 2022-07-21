import com.alibaba.fastjson.JSONArray;
import com.mysql.cj.MysqlConnection;
import com.mysql.cj.jdbc.JdbcConnection;
import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author yuanchangshuai
 * @date 2022/7/4-16:08
 * @description
 */
public class InputData {

    public static void main(String[] args) throws Exception {
        //System.out.println(InputData.class.getClassLoader().getResource("").getPath());
        InputStream resourceAsStream = InputData.class.getClassLoader().getResourceAsStream("response.json");

        int l = 0;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bs = new byte[512];
        while ((l = resourceAsStream.read(bs)) != -1) {
            byteArrayOutputStream.write(bs, 0, l);
        }
        String json = byteArrayOutputStream.toString("UTF-8");
        JSONArray array = JSONArray.parseArray(json);

        Class.forName("com.mysql.cj.jdbc.Driver");
        MysqlConnectionPoolDataSource mysqlConnectionPoolDataSource = new MysqlConnectionPoolDataSource();
        mysqlConnectionPoolDataSource.setUrl("jdbc:mysql://47.102.117.127:3306/ctl-aer");
        mysqlConnectionPoolDataSource.setUser("root");
        mysqlConnectionPoolDataSource.setPassword("cheshenghuo888");
        Connection connection = mysqlConnectionPoolDataSource.getConnection();
        Statement statement = connection.createStatement();


        List<Map> maps = array.toJavaList(Map.class);

        for (Map map : maps) {
            statement.execute(String.format(
                    "INSERT INTO `ctl-aer`.project_item " +
                            "(item_code, item_name, charge_type, work_hour, work_hour_price, car_type, car_type_code, " +
                            "car_type_code_desc, class_id, class_name, engine_type, engine_type_name, remark,  source_type) VALUES " +
                            "('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s');"
                    , map.get("ITEM_NO")
                    , map.get("NAME")
                    , map.get("CHARGE_TYPE")
                    , map.get("REPAIR_TIME")
                    , map.get("REPAIR_MONEY")
                    , map.get("cartype")
                    , map.get("CLASS_TYPE")
                    , map.get("CLASS_NAME")
                    , "0"
                    , map.get("TYPE_NAME")
                    , map.get("ENGINE_TYPE")
                    , map.get("ENGINE_TYPE_NAME")
                    , Optional.ofNullable(map.get("REMARK")).orElse("")
                    , 0
            ));
        }

        resourceAsStream.close();

    }


}
