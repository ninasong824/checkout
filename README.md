# Checkout

The basic requirements for building and running is

1. Java 8 JDK (old laptop, haven't updated for a long time, should use 11+)
2. IntelliJ (doesn't use command line to run)


In project directory ./doc, there is one .mov file (recorded by Mac QuickTime Player, it could convert into .mp4 if you don't have QuickTime Player installed) 
and one png file which show how to start and run test

### Start

In IntelliJ, File->Project Structure->Project settings->Project, choose java 1.8 for Project SDK and language level

In IntelliJ, File->Project Structure->Project settings->Libraries, click '+' to add junit4-runner:5.0.0.0-ALPHA, and mockito-core:4.8.0, you could check ./doc/addLib.png

In IntelliJ, the 'Main' button should be shown in configuration dropdown list, if not, you could click '+' in IntelliJ in 'Edit Configurations', and choose 'Application'
After set it up, click green triangle button to run.

You will see "Please scan: " in console, just enter "ipd" or "mbp" or "atv" or "vga", and hit enter, until you feel it is done, you enter "pay", it will print out total value, and exit.

It is one time thing, if you want to do another checkout, just run the Main again

### Test

To run unit tests, you could set it up in IntelliJ as screenshot in project directory ./doc/settingUpTests

Could add gradlew build/start/test in the future


## Update/Add Pricing Rules

You could go to PricingRules.java to update the existing rule, and you could add more *PricingRules.java (BlackFridayPricingRules as example), and 
add logic in Main.java to control which date and time range to use which PricingRule, or more logic.


