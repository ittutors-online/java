package online.ittutors.javatutorial.spring1;

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
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		MessagePrinter printer = context.getBean(MessagePrinter.class);
		printer.printMessage();

		Resource res = new ClassPathResource("spconfig.xml");
		BeanFactory factory = new XmlBeanFactory(res);
		((WelcomeBean) factory.getBean("id1")).show();
		((WelcomeBean) factory.getBean("id2")).show();

		int age = 10;
		System.out.println("Peter is " + age + " years old");
		if (age < 4)
			System.out.println("Peter is a baby");
		else
			System.out.println("Peter is not a baby anymore");
	}

	@Bean
	MessageService mockMessageService() {
		return new MessageService() {
			public String getMessage() {
				return "Hello World!";
			}
		};
	}
}
