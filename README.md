### Build

To create the image, run the following goal:

```
$ ./gradlew bootBuildImage
```

Then, you can run the app like any other container:

```
$ docker run --rm mp-tractor:0.0.1-SNAPSHOT
```

### Info

Application is running on port 8080
Payload is a string on two line :

```text
(x,y,N)
AGDDDG
```