package com.example.iika;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OnboardingActivity extends AppCompatActivity {

    //Variables
    ViewPager viewPager;
    LinearLayout dotsLayout;
    TextView[] dots;
    Button letsGetStarted;
    SliderAdapter sliderAdapter;
    Animation animation;
    int currentPos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getSupportActionBar().hide();
        setContentView(R.layout.activity_onboarding);

        //Hooks
        viewPager = findViewById(R.id.slider);
        dotsLayout = findViewById(R.id.dots);
        letsGetStarted = findViewById(R.id.get_started_btn);
        //Call adapter
        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);
    }

        public void skip(View view){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        public void next(View view){
            viewPager.setCurrentItem(currentPos + 1);
        }

        public void letsgetstarted(View view) {
        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
    }

    private void addDots(int position) {

            dots = new TextView[4];
            dotsLayout.removeAllViews();

            for (int i = 0; i < dots.length; i++) {
                dots[i] = new TextView(this);
                dots[i].setText(Html.fromHtml("&#8226;"));
                dots[i].setTextSize(35);

                dotsLayout.addView(dots[i]);
            }

            if (dots.length > 0){
                dots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            }
        }

        ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                addDots(position);
                currentPos = position;

                if(position == 0){
                    letsGetStarted.setVisibility(View.INVISIBLE);
                }
                else if(position == 1){
                    letsGetStarted.setVisibility(View.INVISIBLE);

                }
                else if(position == 2){
                    letsGetStarted.setVisibility(View.INVISIBLE);

                }
                else {
                    animation = AnimationUtils.loadAnimation(OnboardingActivity.this,R.anim.side_animation);
                    letsGetStarted.setAnimation(animation);
                    letsGetStarted.setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };

    }
