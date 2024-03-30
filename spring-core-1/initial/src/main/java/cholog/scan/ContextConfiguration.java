package cholog.scan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
/*
ComponentScan에 대해 학습하고, ComponenetScanBean을 Bean으로 등록하기
 */
@ComponentScan(basePackages = "cholog")
//basePackages의 경우 괄호안에 직접 패키지경로를 직접 적어주어 스캔할 위치를 지정할 수 있습니다
//해당 패키지부터 하위 패키지 스캔함
public class ContextConfiguration {
}
