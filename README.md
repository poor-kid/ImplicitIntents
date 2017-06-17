# ImplicitIntents
Let's take a look at the most common implicit intents such as making a phone call, sending a text-message, sending an email, etc.

## Phone Call

Permissions:

```xml
<uses-permission android:name="android.permission.CALL_PHONE" />
```
 ## Implicit Intents

Implicit Intents are requests to perform an action based on a desired action and target data. This is in contrast to an explicit intent that targets a specific activity. For example, if I want to make a phone call for the user, that can be done with this intent:

```java
Intent callIntent = new Intent(Intent.ACTION_CALL);
callIntent.setData(Uri.parse("tel:123"));
startActivity(callIntent);
```

If I want to launch a website in the phone's browser, I might do this:

```java
Intent browserIntent = new Intent(Intent.ACTION_VIEW, 
  Uri.parse("http://www.google.com"));
startActivity(browserIntent);
```


