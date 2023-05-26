# NewOnBackpress
this project having new kotlin back function and fragment navigater
Why is the OnBackPress function Deprecated?🤔
In Android 13, we have a new Preview feature called, Predictive back gesture. Currently, it’s not available for end-Users. Because of this feature,
they deprecated the onBackPressed Function in Android 13. So we are going to migrate and make our apps to get ready for Android 13’s predictive back gesture.


Note: As Android Team mentioned in the note, Predictive back gesture it’s only visible for developers for testing purposes while Targeting Android 13.
// 
override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_main)
      // adding onbackpressed callback listener.
      onBackPressedDispatcher.addCallback(this,onBackPressedCallback)
  }

private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            //showing dialog and then closing the application..
           
        }
   }
