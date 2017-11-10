package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.SumPathEffect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice12PathEffectView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();
    Path effectPath = new Path();

    public Practice12PathEffectView(Context context) {
        super(context);
    }

    public Practice12PathEffectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice12PathEffectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setStyle(Paint.Style.STROKE);

        path.moveTo(50, 100);
        path.rLineTo(50, 100);
        path.rLineTo(80, -150);
        path.rLineTo(100, 100);
        path.rLineTo(70, -120);
        path.rLineTo(150, 80);

        Matrix matrix = new Matrix();
        matrix.postRotate(30);
        effectPath.lineTo(0, 34);
        effectPath.lineTo(30, 17);
        effectPath.close();
        effectPath.transform(matrix);
    }

    PathEffect pathEffect1 = new CornerPathEffect(25);
    PathEffect pathEffect2 = new DiscretePathEffect(20, 6);
    PathEffect pathEffect3 = new DashPathEffect(new float[]{20, 8, 5, 8}, 0);
    PathEffect pathEffect4 = new PathDashPathEffect(effectPath, 40, 0, PathDashPathEffect.Style.ROTATE);
    PathEffect pathEffect5 = new SumPathEffect(pathEffect2, pathEffect3);
    PathEffect pathEffect6 = new ComposePathEffect(pathEffect3, pathEffect2);

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 Paint.setPathEffect() 来设置不同的 PathEffect
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPath(effectPath, paint);
        paint.setStyle(Paint.Style.STROKE);

        // 第一处：CornerPathEffect
        paint.setPathEffect(pathEffect1);
        canvas.drawPath(path, paint);

        canvas.save();
        canvas.translate(500, 0);
        // 第二处：DiscretePathEffect
        paint.setPathEffect(pathEffect2);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 200);
        // 第三处：DashPathEffect
        paint.setPathEffect(pathEffect3);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 200);
        // 第四处：PathDashPathEffect
        paint.setPathEffect(pathEffect4);
        canvas.drawPath(path, paint);
        paint.setPathEffect(null);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 400);
        // 第五处：SumPathEffect
        paint.setPathEffect(pathEffect5);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 400);
        // 第六处：ComposePathEffect
        paint.setPathEffect(pathEffect6);
        canvas.drawPath(path, paint);
        canvas.restore();
    }
}
