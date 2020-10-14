# Cadence demo

## How to run

```
export CADENCE_URL=<to be your cadence host>
export CADENCE_DOMAIN=<to be the cadence domain>

# run the application

./gradlew -PmainClass=com.afterpay.ds.cadence.HelloCadence execute
./gradlew -PmainClass=com.afterpay.ds.cadence.StartWorkflow execute --args='some message'

```

Messages (`some message`) will be logged out from your HelloCadence app, with a 10 second delay.
