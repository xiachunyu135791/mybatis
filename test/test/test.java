package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;
import dao.pojo.user;
import dao.pojo.userlist;
public class test {
@Test
 public void testxml(){
	 Logger log = Logger.getLogger(test.class);
	 String str="mybatis-config.xml";
	 int count = 0;
	 SqlSession sql=null;
	 InputStream is;
	try {
		is = Resources.getResourceAsStream(str);
		 SqlSessionFactory SSF = new SqlSessionFactoryBuilder().build(is);
		 sql = SSF.openSession();
		 count = sql.selectOne("dao.pojo.userlist.count");
		 log.info(count);
		List<user> list = sql.selectList("dao.pojo.userlist.getList");
	      for (user u1 : list) {
		   log.info(u1.toString());
		}
	      System.out.println("--------------------------------------");
	      List<user> list1 = sql.getMapper(userlist.class).getList();
	      for (user u2 : list1) {
			   log.info(u2.toString());
			}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
}
