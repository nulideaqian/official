## Customized Handler Sample

ServiceComb support users to define a customized handler and and invoke the handler in handler chain.

* Customize a handler by implement Handler interface, for example:

  ```java
  public class MyHandler implements Handler {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyHandler.class);
    @Override
    public void handle(Invocation invocation, AsyncResponse asyncResponse) throws Exception {
      //code before
      LOGGER.info("It's my handler! \r\n");
      invocation.next(response -> {
        // code after
        asyncResponse.handle(response);
      });
    }
  }
  ```

* Define handler `id` and `class` in `cse.handler.xml` `config` item under `resources/config` directory

  ```xml
  <config>
      <handler id="myhandler" 		     class="org.apache.servicecomb.samples.customerhandler.handlers.MyHandler" />
  </config>

  ```

   ***NOTICE:*** can use a different name other than `cse.handler.xml`, e.g. `userDefined.hanlder.xml`
   
* Configure customized `MyHandler` in `microservice.yaml` file along with other handler together

  ```yaml
  servicecomb:
    # other configurations omitted
    handler:
      chain:
        Consumer:
          default: bizkeeper-consumer,loadbalance, myhandler
  ```
## Precondition
see [Precondition](../../README.md)


## Sample Quick Start

1. Start the ServiceComb/Service Center

   - [how to start the service center](http://servicecomb.apache.org/docs/products/service-center/install/)
   - make sure service center address is configured correctly in `microservice.yaml` file

```yaml
servicecomb:
 service:
   registry:
     address: http://127.0.0.1:30100		#service center address
```

2. Start the custom-handler-provider service

   - Start provider service by maven

     Compile the source code, and use `mvn exec` to execute the main class `CustomHandlerProviderMain`.

     ```bash
     mvn clean install
     cd custom-handler-sample/custom-handler-provider/
     mvn exec:java -Dexec.mainClass="org.apache.servicecomb.samples.customerhandler.provider.CustomHandlerProviderMain"
     ```

   - Start provider service by IDE

     Import the project by InteliJ IDEA or Eclipse, then find `main` function `CustomHandlerProviderMain` of provider service and `RUN` it like any other Java program.

3. Start the custom-handler-consumer service

   Just like how to start custom-handler-provider service. But the main class of custom-handler-consumer service is `CustomHandlerCustomerMain`. 

   ```bash
   cd custom-handler-sample/custom-handler-consumer
   mvn exec:java -Dexec.mainClass="org.apache.servicecomb.samples.customerhandler.consumer.CustomHandlerCustomerMain"
   ```

4. How to verify
   On the producer side, the output should contain the following stuffs if the producer starts up successfully:
   1. *'swagger: 2.0 info: version: 1.0.0 ...'* means the producer generated swagger contracts
   2. *'rest listen success. address=0.0.0.0:8080'* means the rest endpoint is listening on port 8080
   
   On the consumer side, you can see the following outputs:
   1. *'It's my handler!'* means custom handler had take effect


  