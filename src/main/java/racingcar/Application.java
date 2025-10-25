package racingcar;

/*
camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API 활용
- Random 값 추출: pickNumberInRange()
  ex) Randoms.pickNumberInRange(0, 9); //0에서 9까지 정수 중 한 개 반환
- 사용자 입력 값: readLine()
- 3항 연산자 쓰지 않기
- 단일 역할을 수행하는 작은 함수로 분리하기 -> 다양한 API를 사용하여 데이터 조작하기
- 배열 대신 컬렉션(List, Set, Map 등) 사용하기 -
 */


import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        List<String> carNames = List.of(input.split(","));
        List<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            cars.add(new Car(name.trim()));
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        int count = Integer.parseInt(Console.readLine());

        /*
        경주 게임 로직
         */
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < cars.size(); j++) {
                cars.get(j).move();
            }
        }

        /*
        실행 결과 & 최종 우승자 출력
         */

    }
}
