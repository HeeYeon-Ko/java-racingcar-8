package racingcar;

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
            validateCarName(name.trim());
            cars.add(new Car(name.trim()));
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        int count = validateTryCount(Console.readLine());

        System.out.println();
        System.out.println("실행 결과");

        /*
        경주 게임 로직
        */
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < cars.size(); j++) {
                cars.get(j).move();
                System.out.println(cars.get(j).getName() + " : " + "-".repeat(cars.get(j).getPosition()));
            }
            System.out.println();
        }

        /*
        최종 우승자 출력
        */
        int max = Integer.MIN_VALUE;
        List<Car> winner = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() > max) {
                max = car.getPosition();
            }
        }
        System.out.print("최종 우승자 : ");
        for (Car car : cars) {
            if (car.getPosition() == max) {
                winner.add(car);
            }
        }

        if(winner.size()==1){
            System.out.print(winner.getFirst().getName());
        }
        else{
            for (int i = 0; i < winner.size() - 1; i++) {
                System.out.print(winner.get(i).getName() + ", ");
            }
            System.out.print(winner.getLast().getName());
        }
    }

    //이름 검증 함수
    private static void validateCarName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    //시도 횟수 검증 함수
    private static int validateTryCount(String input) {
        try {
            int count = Integer.parseInt(input);
            if (count <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상의 정수여야 합니다.");
            }
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력할 수 있습니다.");
        }
    }
}
