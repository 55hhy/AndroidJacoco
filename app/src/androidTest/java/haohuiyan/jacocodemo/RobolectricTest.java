package haohuiyan.jacocodemo;

import android.test.ActivityUnitTestCase;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by haohuiyan on 7/16/14.
 */
public class RobolectricTest extends ActivityUnitTestCase<MyActivity> {
    private MyActivity mActivity;

    public RobolectricTest(){
        super(MyActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mActivity = getActivity();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testAdd(){
        int a = 2;
        int b = 3;
        int c = 5;
        EditText firstN = (EditText)mActivity.findViewById(R.id.num1);
        firstN.setText(String.valueOf(a));

        EditText secondN = (EditText)mActivity.findViewById(R.id.num2);
        secondN.setText(String.valueOf(b));

        Button add = (Button)mActivity.findViewById(R.id.add);
        add.performClick();

        TextView result = (TextView)mActivity.findViewById(R.id.result);
        assertEquals(result.getText().toString(), String.valueOf(c));

    }
}
