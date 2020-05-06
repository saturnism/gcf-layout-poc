# Instructions
```
cd gcf-spring-boot-layout
mvn clean install
cd ../helloworld-function
mvn clean install
gcloud alpha functions deploy ray-poc --entry-point org.example.gcf.loader.GcfLauncher  --runtime java11 --trigger-http --source target/deploy --memory 512MB
curl https://{YOUR-REGION-PROJECT}.cloudfunctions.net/ray-poc -d "hello"
```