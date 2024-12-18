package Notification;

import Additional.SMSNotifier;

public class SmsNotificationChannel implements NotificationChannel {
    private final SMSNotifier smsNotifier;
    private final String phoneNumber;

    public SmsNotificationChannel(SMSNotifier smsNotifier, String phoneNumber) {
        this.smsNotifier = smsNotifier;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void notify(String title, String message) {
        smsNotifier.sendSms(phoneNumber, title + System.lineSeparator() + message);
    }
}