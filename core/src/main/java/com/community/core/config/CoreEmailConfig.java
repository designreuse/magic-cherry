package com.community.core.config;

import org.broadleafcommerce.common.email.service.info.EmailInfo;
import org.broadleafcommerce.common.email.service.message.MessageCreator;
import org.broadleafcommerce.common.email.service.message.NullMessageCreator;
import org.broadleafcommerce.presentation.thymeleaf3.config.AbstractThymeleaf3DialectConfig;
import org.broadleafcommerce.presentation.thymeleaf3.email.BroadleafThymeleaf3MessageCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import java.util.Properties;
import java.util.Set;

import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;

/**
 * Shared email configuration
 * 
 * @author Phillip Verheyden (phillipuniverse)
 */
@Configuration
public class CoreEmailConfig extends AbstractThymeleaf3DialectConfig {

    /**
     * A dummy mail sender has been set to send emails for testing purposes only
     * To view the emails sent use "DevNull SMTP" (download separately) with the following setting: 
     *   Port: 30000
     */
    @Bean
    public JavaMailSender blMailSender() {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost("smtp.mail.yahoo.com");
        sender.setPort(465);
        sender.setUsername("yp2211@yahoo.co.jp");
        sender.setPassword("alln@532");
        sender.setProtocol("smtp");
        Properties javaMailProps = new Properties();
        javaMailProps.setProperty("mail.smtp.starttls.enable", ""+true);
        javaMailProps.setProperty("mail.smtp.timeout", "25000");
        sender.setJavaMailProperties(javaMailProps);
        return sender;
    }

    @Bean
    public ClassLoaderTemplateResolver blEmailTemplateResolver() {
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix("emailTemplates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML5");
        resolver.setCacheable(false);
        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }

    @Bean
    public SpringTemplateEngine blEmailTemplateEngine(
            @Qualifier("blEmailTemplateResolver") ClassLoaderTemplateResolver templateResolvers,
            @Qualifier("blEmailDialects") Set<IDialect> dialects) {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolvers);
        engine.setDialects(dialects);
        return null;
    }

    /**
     * Uncomment this bean to send real emails
     */
    @Bean
    @Autowired
    public MessageCreator blMessageCreator(@Qualifier("blEmailTemplateEngine") SpringTemplateEngine tlTemplateEngine, @Qualifier("blMailSender") JavaMailSender mailSender) {
//        return new ThymeleafMessageCreator(tlTemplateEngine, mailSender);
        return new BroadleafThymeleaf3MessageCreator(tlTemplateEngine, mailSender);
    }

//    @Bean
//    @Autowired
//    public MessageCreator blMessageCreator(@Qualifier("blMailSender") JavaMailSender mailSender) {
//        return new NullMessageCreator(mailSender);
//    }
    
    @Bean
    public EmailInfo blEmailInfo() {
        EmailInfo info = getEmailInfo();
        return info;
    }

    private EmailInfo getEmailInfo() {
        EmailInfo info = new EmailInfo();
//        info.setFromAddress("support@mycompany.com");
        info.setFromAddress("yp2211@yahoo.co.jp");
        info.setSendAsyncPriority("2");
        info.setSendEmailReliableAsync("false");
        return info;
    }
    
    @Bean
    public EmailInfo blRegistrationEmailInfo() {
        EmailInfo info = getEmailInfo();
        info.setSubject("You have successfully registered!");
        info.setEmailTemplate("register-email");
        return info;
    }
    
    @Bean
    public EmailInfo blForgotPasswordEmailInfo() {
        EmailInfo info = getEmailInfo();
        info.setSubject("Reset password request");
        info.setEmailTemplate("resetPassword-email");
        return info;
    }
    
    @Bean
    public EmailInfo blOrderConfirmationEmailInfo() {
        EmailInfo info = getEmailInfo();
        info.setSubject("Your order with The Magic Cherry");
        info.setEmailTemplate("orderConfirmation-email");
        return info;
    }
    
    @Bean
    public EmailInfo blFulfillmentOrderTrackingEmailInfo() {
        EmailInfo info = getEmailInfo();
        info.setSubject("Your order with The Magic Cherry Has Shipped");
        info.setEmailTemplate("fulfillmentOrderTracking-email");
        return info;
    }
    
    @Bean
    public EmailInfo blReturnAuthorizationEmailInfo() {
        EmailInfo info = getEmailInfo();
        info.setSubject("Your return with The Magic Cherry");
        info.setEmailTemplate("returnAuthorization-email");
        return info;
    }
    
    @Bean
    public EmailInfo blReturnConfirmationEmailInfo() {
        EmailInfo info = getEmailInfo();
        info.setSubject("Your return with The Magic Cherry");
        info.setEmailTemplate("returnConfirmation-email");
        return info;
    }
}
