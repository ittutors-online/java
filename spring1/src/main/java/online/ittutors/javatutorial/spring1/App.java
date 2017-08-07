package online.ittutors.javatutorial.spring1;

import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
@ComponentScan
public class App {

	@Bean
	MessageService mockMessageService() {
		return new MessageService() {
			public String getMessage() {
				return "Hello World!";
			}
		};
	}

	public static void main(String[] args) {
		// Resource res = new ClassPathResource("spconfig.xml");
		// BeanFactory factory = new XmlBeanFactory(res);
		// ((WelcomeBean) factory.getBean("id1")).show();
		// ((WelcomeBean) factory.getBean("id2")).show();
		//
		// ApplicationContext context = new
		// AnnotationConfigApplicationContext(App.class);
		// MessagePrinter printer = context.getBean(MessagePrinter.class);
		// printer.printMessage();

		for (int i = 1; i <= 10; ++i) {//SIMPLE FOR LOOP
			System.out.println("Line " + i);
		}
	}
}
