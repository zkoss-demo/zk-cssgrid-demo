import org.zkoss.chart.Charts;
import org.zkoss.chart.model.CategoryModel;
import org.zkoss.chart.model.DefaultCategoryModel;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;

import java.util.List;

/**
 * Created by wenninghsu on 19/07/2017.
 */
public class ColumnParsedComposer extends SelectorComposer<Div> {

	@Wire
	Charts chart;

	public void doAfterCompose(Div comp) throws Exception {
		super.doAfterCompose(comp);

		chart.getYAxis().setAllowDecimals(false);
		chart.getYAxis().getTitle().setText("Units");

		CategoryModel catemodel = new DefaultCategoryModel();
		for (Food food : ColumnParsedData.getFoods()) {
			Integer[] unit = (Integer[]) food.getUnits().toArray();
			for (int i = 0; i < unit.length; ++i) {
				catemodel.setValue(getPeople().get(i), food.getName(), unit[i]);
			}
		}
		chart.setModel(catemodel);
	}

	public ListModel<Food> getFoods() {
		return new ListModelList<Food>(ColumnParsedData.getFoods(), true);
	}

	public List<String> getPeople() {
		return ColumnParsedData.getPeople();
	}

}