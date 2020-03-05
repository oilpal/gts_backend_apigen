
- DB 스키마로 부터 메타데이터 생성  
> mvn -Pmetadata generate-sources
- 코드제네레이트  
> mvn -Pgen generate-sources

- 모두 한번에 실행  
> mvn -Pmetadata,gen generate-sources
