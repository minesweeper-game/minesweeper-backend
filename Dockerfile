FROM gradle:7-jdk17 as builder
WORKDIR /app
ENV PORT 8080
ENV HOST 0.0.0.0
COPY . .
RUN ./gradlew build --stacktrace

FROM openjdk
WORKDIR /app
#EXPOSE 80
COPY --from=builder /app/build/libs/minesweeper-backend-0.0.1.jar .
CMD java -jar minesweeper-backend-0.0.1.jar