5 methods of JobInfo.Builder

1.setMinimumLatency

  public JobInfo.Builder setMinimumLatency (long minLatencyMillis)

  Specify that this job should be delayed by the provided amount of time

2.setPeriodic
  Added in API level 21
  public JobInfo.Builder setPeriodic (long intervalMillis)

  Specify that this job should recur with the provided interval, not more than once per period.
  You have no control over when within this interval this job will be executed, only the guarantee
  that it will be executed at most once within this interval

3.setRequiredNetwork
  public JobInfo.Builder setRequiredNetwork (NetworkRequest networkRequest)

  If your job doesn't need a network connection, you don't need to call this method, as the default is null.

  Calling this method defines network as a strict requirement for your job. If the network requested is not available your job will never run4

4.setRequiresBatteryNotLow
  Added in API level 26
  public JobInfo.Builder setRequiresBatteryNotLow (boolean batteryNotLow)

  Specify that to run this job, the device's battery level must not be low. This defaults to false. If true,
  the job will only run when the battery level is not low,
  which is generally the point where the user is given a "low battery" warning.

5.setRequiresCharging
  Added in API level 21
  public JobInfo.Builder setRequiresCharging (boolean requiresCharging)

  Specify that to run this job, the device must be charging (or be a non-battery-powered device connected to permanent power,
  such as Android TV devices). This defaults to false.