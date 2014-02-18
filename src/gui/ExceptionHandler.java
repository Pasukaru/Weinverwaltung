package gui;

import gui.mainwindow.MainWindow;

import java.net.SocketException;

import javax.swing.JOptionPane;

import util.JpaUtil;

public class ExceptionHandler implements util.ExceptionHandler {

	private MainWindow mainWindow;
	
	public ExceptionHandler(MainWindow mainWindow){
		this.mainWindow = mainWindow;
	}
	
	@Override
	public void handleException(Exception e) {
		boolean connectionLost = false;
		
		//Travel the cause chain to look for a SocketException
		Throwable cause = e.getCause();
		while(cause != null){
			if(cause instanceof SocketException){
				connectionLost = true;
				break;
			}
			cause = cause.getCause();
		}
		
		if(connectionLost){
			JOptionPane.showMessageDialog(mainWindow, "Verbindung zur Datenbank kann nicht hergestellt werden.\nStarten Sie den Datenbankserver und führen Sie die Applikation erneut aus.", "Fehler", JOptionPane.ERROR_MESSAGE);
			JpaUtil.close();
			System.exit(1);
		} else {
			JOptionPane.showMessageDialog(mainWindow, "Unbehandelter Fehler: "+e.getMessage());
			throw new RuntimeException("Unbehandelter Fehler", e);
		}
	}

}
