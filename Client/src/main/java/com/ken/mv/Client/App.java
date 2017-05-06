package com.ken.mv.Client;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.ken.entity.User;
import com.ken.service.IHessianService;

public class App 
{
    public static void main( String[] args )
    {
    	
        Display display = new Display();
    	final Shell shell = new Shell(display,SWT.SHELL_TRIM);
    	shell.setSize(300, 300);
    	shell.setText("Hessian");
    	shell.setLayout(new FormLayout());
    	
    	
    		
    	final Group group = new Group(shell,SWT.SHADOW_ETCHED_IN);
    	group.setText("用户查询");
    	final GridData gd_group = new GridData(SWT.FILL,SWT.FILL,true,true);
    	gd_group.heightHint = 100;
    	//group.setData(gd_group);
        
    	org.eclipse.swt.layout.GridLayout gridLayout = new org.eclipse.swt.layout.GridLayout(2, true);
		
		gridLayout.verticalSpacing = 5;
		gridLayout.horizontalSpacing = 5;
		gridLayout.marginLeft = 10;
		gridLayout.marginRight = 10;
		gridLayout.marginTop = 10;
		
		group.setLayout(gridLayout);
		
		
		final Label idLabel = new Label(group,SWT.NONE);
		final GridData gd_idLabel = new GridData(SWT.LEFT,SWT.CENTER,false,false);
		idLabel.setText("ID:");
		idLabel.setData(gd_idLabel);
		
		final Text idText = new Text(group,SWT.BORDER);
		final GridData gd_idText = new GridData(SWT.LEFT,SWT.CENTER,false,false);
		gd_idText.widthHint = 100;
		idText.setData(gd_idText);
		
		final Label userNameLabel = new Label(group,SWT.NONE);
		final GridData gd_userNameLabel = new GridData(SWT.LEFT,SWT.CENTER,false,false);
		userNameLabel.setText("UserName:");
		userNameLabel.setData(gd_userNameLabel);
		
		final Text userNameText = new Text(group,SWT.BORDER);
		final GridData gd_userNameText = new GridData(SWT.LEFT,SWT.CENTER,false,false);
		gd_userNameText.widthHint = 100;
		userNameText.setData(gd_userNameText);
		
		final Label sexLabel = new Label(group,SWT.NONE);
		final GridData gd_sexLabel = new GridData(SWT.LEFT,SWT.CENTER,false,false);
		sexLabel.setText("Sex");
		sexLabel.setData(gd_sexLabel);
		
		final Text sexText = new Text(group,SWT.BORDER);
		final GridData gd_sexText = new GridData(SWT.LEFT,SWT.CENTER,false,false);
		gd_sexText.widthHint = 100;
		sexText.setData(gd_sexText);
		
		Button searchButton = new Button(group,SWT.NONE);
		final GridData gd_searchButton = new GridData(SWT.CENTER,SWT.CENTER,false,false);
		searchButton.setData(gd_searchButton);
		searchButton.setText("Search");
		searchButton.addMouseListener(new MouseListener(){

			public void mouseDoubleClick(MouseEvent e) {
				
			}

			public void mouseDown(MouseEvent e) {
				//调用hessian服务，获取数据
				ApplicationContext context = new ClassPathXmlApplicationContext("hessian-client.xml");
				IHessianService service = (IHessianService)context.getBean("hessianService");
				String value = idText.getText();
				int id = Integer.parseInt(value);
				User user = service.getUserById(id);
				if(null!=user){
					userNameText.setText(user.getUserName());
					sexText.setText(user.getSex());
				} else {
					MessageBox box = new MessageBox(shell);
					box.setText("Tip");
					box.setMessage("User Not Found");
					box.open();
				}
			}

			public void mouseUp(MouseEvent e) {			
				
			}
			
		});
        
        
        
        
		shell.open();
    
    	while(!shell.isDisposed()){
    		if(!display.readAndDispatch()) {
    			display.sleep();
    		}
    	}
    	display.dispose();
    	
       
        
    }
}
