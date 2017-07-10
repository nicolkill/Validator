# Validator
 [ ![Download](https://api.bintray.com/packages/nicolkill/android/Validator/images/download.svg) ](https://bintray.com/nicolkill/android/Validator/_latestVersion)
 [![Build Status](https://travis-ci.org/nicolkill/Validator.svg?branch=master)](https://travis-ci.org/nicolkill/Validator)

**Validator** is a library that help to make validations easy, with the custom edit text .

## Features
  - Easy implementation
  - Validation out of views

### ***For more functions or bugs, create a [issue](https://github.com/nicolkill/Validator/issues).***

## **Usage**
#### Add gradle dependecy
```
dependencies {
  compile 'com.nicolkill:validator:{latest_release}'
}
```
### Step 1:

## if you want use only validator
#### Example with created validator
```java
Validator validator = new PhoneValidator();
if (validator.isValid("123456789a")) {
    // some stuff
} else {
    // another stuff
}
```
#### Example with self maked validator
```java
Validator validator = new Validator() {
    @Override
    public boolean isValid(String text) {
        // check if text size is greater that 20
        return text.length() > 20;
    }
};
if (validator.isValid("abcdefghijklmnopqrstuvwxyz")) {
    // some stuff
} else {
    // another stuff
}
```

## If you want use the custom view

### Step 1:
#### Add the following xml on your view:
```xml
<com.nicolkill.validator.views.ValidateTextInputLayout
    app:type_validator="email"
    app:text_error="@string/invalid_mail"
    android:id="@+id/edit1"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">

    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="@string/mail"
        android:text="correo@correo.com"/>

</com.nicolkill.validator.views.ValidateTextInputLayout>
```
or

```xml
<com.nicolkill.validator.views.ValidateEditText
    app:type_validator="name"
    app:text_error="@string/invalid_name"
    android:id="@+id/edit2"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:hint="@string/name" />
```
### Step 2:
#### Get reference and set data:
```java
ValidateTextInputLayout mValidateTextInputLayout = (ValidateTextInputLayout) findViewById(R.id.edit1);
ValidateEditText mValidateEditText = (ValidateEditText) findViewById(R.id.edit2);
```
### Step 3:
#### Check if the field is valid
```java
adapter.setOnClickListener(new ClickListener<Option>() {
    @Override
    public void onItemSelected(View view, int position, Option element) {
        if (mValidateTextInputLayout.isValid() && mValidateEditText.isValid()) {
            // some stuff
        } else {
            // another stuff
        }
    }
});
```

