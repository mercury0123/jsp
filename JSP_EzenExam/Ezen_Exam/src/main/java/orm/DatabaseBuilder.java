package orm;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DatabaseBuilder {
	
	private static SqlSessionFactory factory;
	private static final String Config = "orm/MybatisConfig.xml";	
	//MybatisConfig 환경설정을 Config에 가져오기
	
	//초기화 블럭을 사용하여 객체 생성 후 초기화
	static {
		try {
			factory = new SqlSessionFactoryBuilder()
						.build(Resources.getResourceAsReader(Config)); //ibatis.io 관련
		} catch (IOException e) {
			//mybatis 설정 오류시 메세지
			e.printStackTrace();
		}
	}
	
	//싱글턴 패턴으로
	public static SqlSessionFactory getFactory() {
		return factory;
	}
}