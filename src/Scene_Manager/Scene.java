/**
 * 
 */
package Scene_Manager;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import Game_System.Item;

/**
 * Description
 * 
 * @author Tyrone Lagore
 * @version v1.1 - Mar 28, 2014
 */
public class Scene {
	private String m_Title;
	private String m_Desc;
	private Item m_UnlockItem;
	private Item m_DropItem;
	private ArrayList<Scene> m_Connections;
	private ArrayList<String> m_ConnectionLabels;
	private boolean m_ConnectedTo;
	private static final int MAX_CONNECTIONS = 4;
	private String m_Note;
	private ImageIcon m_Image;

	public Scene(String title, String desc) {
		m_UnlockItem = null;
		m_DropItem = null;
		m_Connections = new ArrayList<Scene>();
		m_ConnectionLabels = new ArrayList<String>();
		m_Title = title;
		m_Desc = desc;
		m_ConnectedTo = false;
		m_Note = "";
		m_Image = null;
	}

	public void addConnection(Scene toConnect, String connectionLabel) 
	{
		if (m_Connections.size() < MAX_CONNECTIONS) {
			m_Connections.add(toConnect);
			m_ConnectionLabels.add(connectionLabel);
		}
	}

	public void removeConnection(int indexToRemove) 
	{

		if (m_Connections.get(indexToRemove) != null) {
			m_Connections.remove(indexToRemove);
			m_ConnectionLabels.remove(indexToRemove);
		}
	}

	public void modifyLabelByIndex(int indexOfScene, String newLabel) {
		m_ConnectionLabels.remove(indexOfScene);
		m_ConnectionLabels.add(indexOfScene, newLabel);
		
	}
	
	
	public void addImageToScene(ImageIcon image)	{ m_Image = image;		}
	public void setSceneIsConnected(boolean bIsConnected) 
													{ m_ConnectedTo = bIsConnected; }
	public boolean getSceneIsConnected() 			{ return m_ConnectedTo; }

	/**
	 * Getters/setters for connecting an item that drops on this scene
	 * @param toConnect the Item being connected
	 */
	public void connectDropItem(Item toConnect) 	{ m_DropItem = toConnect; 	}
	public Item getDropItem() 						{	return m_DropItem; 		}
	public void removeDropItem() 					{	m_DropItem = null; 		}

	/**
	 * Getters/setters for connecting an item that unlocks this scene
	 * @param toConnect the Item being connected
	 */
	public void connectUnlockItem(Item toConnect) 	{ m_UnlockItem = toConnect; }
	public void removeUnlockItem() 					{ m_UnlockItem = null; 		}
	public Item getUnlockItem()			 			{ return m_UnlockItem; 		}

	/* Getters/Setters */
	public ImageIcon getImage()						{ return m_Image;			}
	public void setNote(String note)				{ m_Note = note;			}
	public String getNote()							{ return m_Note;			}
	public String getTitle() 						{ return m_Title; 			}
	public String getDesc() 						{ return m_Desc; 			}
	public ArrayList<String> getConnectionLabels() 	{ return m_ConnectionLabels;}
	public ArrayList<Scene> getConnections() 		{ return m_Connections; 	}
	public void setTitle(String m_Title) 			{ this.m_Title = m_Title;	}
	public void setDesc(String m_Desc) 				{ this.m_Desc = m_Desc; 	}
	public String toString() 						{ return getTitle(); 		}
}
