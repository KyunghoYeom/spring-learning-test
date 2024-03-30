package cholog.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConstructorInjection {
    private InjectionBean injectionBean;

    /*
    ConstructorInjection으로 InjectionBean 주입받기
     */

    //생성자 하나밖에 없으면 spring bean으로 등록 시 Autowired 생략 가능
    public ConstructorInjection(InjectionBean injectionBean){
        this.injectionBean = injectionBean;
    }
    public String sayHello() {

        return injectionBean.hello();
    }
}
