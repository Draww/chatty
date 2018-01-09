
package chatty.gui.components.menus;

import chatty.lang.Language;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;

/**
 *
 * @author tduva
 */
public class HistoryContextMenu extends ContextMenu {

    private static final String RANGE_MENU = Language.getString("channelInfo.viewers.cm.timeRange");
    
    public HistoryContextMenu() {
        addRadioItem("range60", format(1), RANGE_MENU, RANGE_MENU);
        addRadioItem("range120", format(2), RANGE_MENU, RANGE_MENU);
        addRadioItem("range240", format(4), RANGE_MENU, RANGE_MENU);
        addRadioItem("range480", format(8), RANGE_MENU, RANGE_MENU);
        addRadioItem("range720", format(12), RANGE_MENU, RANGE_MENU);
        addSeparator(RANGE_MENU);
        addRadioItem("range-1", Language.getString("channelInfo.viewers.cm.timeRange.all"), RANGE_MENU, RANGE_MENU);
        addCheckboxItem("toggleVerticalZoom", Language.getString("channelInfo.viewers.cm.verticalZoom"), false);
    }
    
    private String format(int hours) {
        return Language.getString("channelInfo.viewers.cm.timeRange.option", hours);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        for (ContextMenuListener l : getContextMenuListeners()) {
            l.menuItemClicked(e);
        }
    }
    
    public void setRange(int range) {
        String key = "range"+range;
        JMenuItem item = getItem(key);
        if (item != null) {
            item.setSelected(true);
        }
    }
    
    public void setZoom(boolean zoom) {
        getItem("toggleVerticalZoom").setSelected(zoom);
    }
    
}
