package haohuiyan.jacocodemo;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import android.widget.TextView;

import com.robotium.solo.Solo;

/**
 * Created by haohuiyan on 7/15/14.
 */
public class MyActivityTest extends ActivityInstrumentationTestCase2<MyActivity> {
    private Solo solo;

    public MyActivityTest(){
        super(MyActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
    }

    @Override
    protected void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    public void testAdd(){
        int number1 = 2;
        int number2 = 3;
        int result = 5;

        EditText firText = (EditText)solo.getView(R.id.num1);
        solo.clearEditText(firText);
        solo.enterText(firText, String.valueOf(number1));

        EditText secText = (EditText)solo.getView(R.id.num2);
        solo.clearEditText(secText);
        solo.enterText(secText, String.valueOf(number2));

        solo.clickOnButton("Add");

        assertTrue(solo.searchText(String.valueOf(result)));

        TextView resText = (TextView)solo.getView(R.id.result);

        assertEquals(String.valueOf(result), resText.getText().toString());
    }
}
