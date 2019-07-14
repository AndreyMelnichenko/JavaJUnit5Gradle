**Run tests:** 

`./gradlew test`
`./gradlew test --tests "com.OpenMainPage.openPage" allureReport`
---
Integrate System.getProperty with Gradle and Intellij IDEA sys options
1. Save local sys environments into Intellij IDEA by `RUN/DEBUG` tool
screen `main/resources/sysOptions.png`
2. Set-up task into `build.garadle`
3. Run code with command line with parameters
example: `./gradlew -Dfour=4 execute` or `./gradlew execute -Dfour=4`
