package model;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Calendar;

public abstract class Model implements Serializable {

	private static final long serialVersionUID = 1L;

	public abstract Integer getId();
	
	@Override
	public String toString() {
		Class<?> clazz = this.getClass();

		ArrayList<Field> fs = new ArrayList<Field>();
		for (Field f : clazz.getDeclaredFields()) {
			if (!Modifier.isStatic(f.getModifiers())) {
				fs.add(f);
			}
		}

		StringBuffer sb = new StringBuffer(clazz.getSimpleName());
		sb.append(" [");
		for (int i = 0, n = fs.size(), last = n - 1; i < n; i++) {
			Field f = fs.get(i);
			f.setAccessible(true);
			sb.append(f.getName());
			sb.append("=");
			try {
				Object value = f.get(this);
				if (value == null) {
					sb.append("null");
				} else if (value instanceof Model) {
					sb.append("[");
					sb.append(value.getClass().getSimpleName());
					sb.append("]");
				} else if (value instanceof Calendar) {
					Calendar cal = (Calendar) value;
					sb.append(cal.get(Calendar.YEAR));
					sb.append("-");
					sb.append(cal.get(Calendar.MONTH) + 1);
					sb.append("-");
					sb.append(cal.get(Calendar.DAY_OF_MONTH));
				} else {
					// sb.append(value);
				}
			} catch (IllegalArgumentException e) {
				sb.append("null");
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				sb.append("null");
				e.printStackTrace();
			}
			if (i != last) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}
}
