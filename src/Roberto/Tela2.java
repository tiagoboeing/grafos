package Roberto;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;

public class Tela2 extends Shell {
	private Text lbVertices;
	private Text lbArestas;
	static Label lbResultado1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			Tela2 shell = new Tela2(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public Tela2(Display display) {
		
		super(display, SWT.SHELL_TRIM | SWT.BORDER);
		setImage(SWTResourceManager.getImage(Tela2.class, "/javax/swing/plaf/metal/icons/Warn.gif"));				
		
		Label lblVrticesEx = new Label(this, SWT.NONE);
		lblVrticesEx.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		lblVrticesEx.setBounds(33, 10, 170, 32);
		lblVrticesEx.setText("V\u00E9rtices [ Ex: A, B, C ] :");
		
		Label lblArestasExabac = new Label(this, SWT.NONE);
		lblArestasExabac.setText("Arestas [ Ex:(A,B),(A,C) ] :");
		lblArestasExabac.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		lblArestasExabac.setBounds(10, 48, 193, 32);
		
		lbVertices = new Text(this, SWT.BORDER);
		lbVertices.setBounds(209, 10, 390, 21);
		
		lbArestas = new Text(this, SWT.BORDER);
		lbArestas.setBounds(209, 48, 390, 21);
		
		Button btnCalcular = new Button(this, SWT.NONE);
		btnCalcular.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				new RealizaCalculo(lbVertices.getText(), lbArestas.getText());
			}
		});
		btnCalcular.setImage(SWTResourceManager.getImage(Tela2.class, "/javax/swing/plaf/metal/icons/ocean/hardDrive.gif"));
		btnCalcular.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.ITALIC));
		btnCalcular.setBounds(219, 75, 110, 32);
		btnCalcular.setText("Calcular");
		
		lbResultado1 = new Label(this, SWT.NONE);
		lbResultado1.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lbResultado1.setAlignment(SWT.CENTER);
		lbResultado1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		lbResultado1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		lbResultado1.setBounds(10, 113, 589, 198);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Calculando Centro do Grafo");
		setSize(625, 354);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
