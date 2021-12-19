package com.helloworld.hello;

import com.helloworld.hello.HelloService;
import com.helloworld.lang.Lang;
import com.helloworld.lang.LangRepository;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class HelloServiceTest {
    private static final String WELCOME = "Hello";
    private static final String FALLBACK_ID_WELCOME = "Hello";

    @Test
    public void test_nullName_prepareGreeting_returnsFallbackName() throws Exception {
        // Given + when
        var mockRepository = alwaysReturningHelloRepository();
        var SUT = new HelloService(mockRepository);

        // When
        var result = SUT.prepareGreeting(null, -1);

        //Then
        assertEquals(WELCOME + " " + HelloService.FALLBACK_NAME + "!", result);
    }

    @Test
    public void test_prepareGreeting_name_returnsGreetingWithName() throws Exception {
        // Given
        var SUT = new HelloService();
        var name = "test";
        // When
        var result = SUT.prepareGreeting(name, -1);

        //Then
        assertEquals(WELCOME + " " + name + "!", result);
    }

    @Test
    public void test_prepareGreeting_nonExistingLang_returnsGreetingWithFallbackLang() throws Exception {
        // Given
        var mockRepository = new LangRepository() {
            @Override
            public Optional<Lang> findById(Integer id) {
                return Optional.empty();
            }
        };

        var SUT = new HelloService(mockRepository);

        // When
        var result = SUT.prepareGreeting(null, -1);

        //Then
        assertEquals(HelloService.FALLBACK_LANG.getWelcomeMessage() + " " + HelloService.FALLBACK_NAME + "!", result);
    }


    @Test
    public void test_prepareGreeting_nullLang_returnsGreetingWithFallbackIdLang() throws Exception {
        // Given
        var fallbackIdWelcome = "Holla";
        var mockRepository = fallbackLangIdRepository();

        var SUT = new HelloService(mockRepository);

        // When
        var result = SUT.prepareGreeting(null, null);

        //Then
        assertEquals(FALLBACK_ID_WELCOME + " " + HelloService.FALLBACK_NAME + "!", result);
    }

//    @Test
//    public void test_prepareGreeting_textLang_returnsGreetingWithFallbackIdLang() throws Exception {
//        // Given
//        var fallbackIdWelcome = "Holla";
//        var mockRepository = fallbackLangIdRepository();
//
//        var SUT = new HelloService(mockRepository);
//
//        // When
//        var result = SUT.prepareGreeting(null, "abc");
//
//        //Then
//        assertEquals(FALLBACK_ID_WELCOME + " " + HelloService.FALLBACK_NAME + "!", result);
//    }

        private LangRepository alwaysReturningHelloRepository () {
                return new LangRepository() {
                @Override
                public Optional<Lang> findById(Integer id) {
                    return Optional.of(new Lang(null, WELCOME, null));
                }
            };
        }

        private LangRepository fallbackLangIdRepository () {
            return new LangRepository() {
                @Override
                public Optional<Lang> findById(Integer id) {
                    if (id.equals(HelloService.FALLBACK_LANG.getId())) {
                        return Optional.of(new Lang(null, FALLBACK_ID_WELCOME, null));
                    }
                    return Optional.empty();
                }
            };
        }
    }
