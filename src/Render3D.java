import java.util.ArrayList;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;

public class Render3D implements GLEventListener{

	ArrayList<Object3D> Objets = new ArrayList<Object3D>();
	Object3D cube1 = new Cube(0f, 0f, -10f, 0.25f, 0f, 0f, 5f, false);
	Object3D cube2 = new Cube(0f, 0f, -5f, 0.125f, 0f, 5f, 0f, true);
	
	@Override
	public void display(GLAutoDrawable arg0) {
		GL2 gl = arg0.getGL().getGL2();
		gl.glClear(gl.GL_COLOR_BUFFER_BIT | gl.GL_DEPTH_BUFFER_BIT);
		//gl.glLoadIdentity();
		update();
		render(arg0);
	}

	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(GLAutoDrawable arg0) {
		GL2 gl = arg0.getGL().getGL2();
		gl.glShadeModel(GL.GL_LINE_SMOOTH);
		gl.glEnable(GL.GL_DEPTH_TEST);
		gl.glDepthFunc(GL.GL_LEQUAL);
		gl.glHint(gl.GL_PERSPECTIVE_CORRECTION_HINT, gl.GL_NICEST);
		gl.glMatrixMode(gl.GL_MODELVIEW);
		gl.glLoadIdentity();
		
		Objets.add(cube1);
		Objets.add(cube2);
	}

	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
		GL2 gl = arg0.getGL().getGL2();
		gl.glViewport(0, 0, arg3, arg4);
		gl.glMatrixMode(gl.GL_PROJECTION);
		gl.glLoadIdentity();
		GLU glu = new GLU();
		glu.gluPerspective(45f, (float)arg3/(float)arg4, 0.1f, 100f);
		gl.glMatrixMode(gl.GL_MODELVIEW);
		gl.glLoadIdentity();
	}
	
	public void render(GLAutoDrawable arg0){
		for (Object3D Objets : Objets) {
			Objets.render(arg0);
		}
	}
	
	public void update(){
		for (Object3D Objets : Objets) {
			Objets.update();
		}
	}
	
}
