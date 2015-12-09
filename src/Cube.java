import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class Cube implements Object3D{
	private float x;
	private float y;
	private float z;
	private float l;
	private float tx;
	private float ty;
	private float tz;
	private float speedx = 0;
	private float speedy = 0;
	private float speedz = 0;
	private boolean orbit;
	
	public Cube(float x, float y, float z, float l, float tx, float ty, float tz, boolean orbit){
		this.x = x;
		this.y = y;
		this.z = z;
		this.l = l;
		this.tx = tx;
		this.ty = ty;
		this.tz = tz;
		this.orbit = orbit;
	}
	
	public void render(GLAutoDrawable arg0){
		GL2 gl = arg0.getGL().getGL2();
		gl.glLoadIdentity();
		
		gl.glPushMatrix();
			gl.glTranslatef(x, y, z);
			gl.glRotatef(speedx, 1f, 0f, 0f);
			gl.glRotatef(speedy, 0f, 1f, 0f);
			gl.glRotatef(speedz, 0f, 0f, 1f);

			if(orbit)
				gl.glTranslatef(x, y, z);
			
			
			gl.glBegin(gl.GL_QUADS);
				//front
				gl.glColor3f(1.0f,0.0f,0.0f);
				gl.glVertex3f(-l,-l,-l);
				gl.glVertex3f(+l,-l,-l);
				gl.glVertex3f(+l,+l,-l);
				gl.glVertex3f(-l,+l,-l);
				
				//back
				gl.glColor3f(1.0f,0.0f,0.0f);
				gl.glVertex3f(-l,-l,+l);
				gl.glVertex3f(+l,-l,+l);
				gl.glVertex3f(+l,+l,+l);
				gl.glVertex3f(-l,+l,+l);
				
				//left
				gl.glColor3f(0.0f,1.0f,0.0f);
				gl.glVertex3f(-l,-l,-l);
				gl.glVertex3f(-l,-l,+l);
				gl.glVertex3f(-l,+l,+l);
				gl.glVertex3f(-l,+l,-l);
				
				//right
				gl.glColor3f(0.0f,1.0f,0.0f);
				gl.glVertex3f(+l,-l,-l);
				gl.glVertex3f(+l,-l,+l);
				gl.glVertex3f(+l,+l,+l);
				gl.glVertex3f(+l,+l,-l);
				
				//bottom
				gl.glColor3f(0.0f,0.0f,1.0f);
				gl.glVertex3f(-l,-l,-l);
				gl.glVertex3f(-l,-l,+l);
				gl.glVertex3f(+l,-l,+l);
				gl.glVertex3f(+l,-l,-l);
				
				//top
				gl.glColor3f(0.0f,0.0f,1.0f);
				gl.glVertex3f(-l,+l,-l);
				gl.glVertex3f(-l,+l,+l);
				gl.glVertex3f(+l,+l,+l);
				gl.glVertex3f(+l,+l,-l);
				
			gl.glEnd();
		gl.glPopMatrix();
		
	}
	
	public void update(){
		this.speedx+=this.tx;
		this.speedy+=this.ty;
		this.speedz+=this.tz;
	}
}
