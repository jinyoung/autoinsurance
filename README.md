# autoinsurance

## Customer 등록
- `http localhost:18080/customers firstName="BC" lastName="A" birthDate="1986-10-15" streetAddress="street " aptUnitNumber="unit" city="city" state="state" zipcode="zip"`

## 신용조회 여부 등록
- 외부서비스(MOCK)으로 socialSecurityNumber가 짝수면 "A등급", 홀수면 "D등급"으로 발급됨
- `http PATCH "http://localhost:18080/customers/BCA" socialSecurityNumber=3533349` #신용조회 D등급(MOCK)으로 가입 오류
- `http PATCH "http://localhost:18080/customers/BCA" socialSecurityNumber=3533348` #신용조회 A등급(MOCK)으로 가입 승인

## Vehicle 등록
- `http localhost:18080/vehicle id="BCA1" type="type" make="make" model="model" year="2018" customer="http://localhost:18080/customers/BCA"`
- `http localhost:18080/vehicle id="BCA2" type="type" make="make" model="model" year="2018" customer="http://localhost:18080/customers/BCA"`
- `http localhost:18080/vehicle id="BCA3" type="type" make="make" model="model" year="2018" customer="http://localhost:18080/customers/BCA"`

## 보유 Vehicle 조회
- `http localhost:18080/customers/BCA/vehicles`

## PolicyHolder 등록
- `http localhost:18080/policyholder customer=http://localhost:18080/customers/BCA`

## InsurancePolicy 생성
- `http localhost:18080/insurance-policy state="Quote Created" vehicle="http://localhost:18080/vehicle/BCA1"`

## 추가정보 입력
- `http PATCH "http://localhost:18080/customers/BCA" gender="m" marritalStatus="m"`
- `http PATCH "http://localhost:18080/policyholder/1" highestEduLevel="h" accidentHistory="none"`
- `http PATCH "http://localhost:18080/vehicle/BCA1" primaryUsage="p" parkingZipcode="z" ownership="own"`

## InsuredDriver 추가
- 원하는 만큼 반복 추가
- `http localhost:18080/customers firstName="Driver" lastName="Insured" birthDate="1986-10-15" driverLicenseNumber="1111" gender="m" marritalStatus="m"`
- `http localhost:18080/insured-drivers customer="http://localhost:18080/customers/DriverInsured" insurancePolicy="http:// localhost:18080/insurance-policy/2" relationToPolicyholder="father"`

## Insurance Policy의 적격성 평가

