package lasalle.edu.co.views;


import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Nav;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.router.Layout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.lumo.LumoUtility.AlignItems;
import com.vaadin.flow.theme.lumo.LumoUtility.BoxSizing;
import com.vaadin.flow.theme.lumo.LumoUtility.Display;
import com.vaadin.flow.theme.lumo.LumoUtility.FlexDirection;
import com.vaadin.flow.theme.lumo.LumoUtility.FontSize;
import com.vaadin.flow.theme.lumo.LumoUtility.FontWeight;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Height;
import com.vaadin.flow.theme.lumo.LumoUtility.ListStyleType;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import com.vaadin.flow.theme.lumo.LumoUtility.Overflow;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import com.vaadin.flow.theme.lumo.LumoUtility.TextColor;
import com.vaadin.flow.theme.lumo.LumoUtility.Whitespace;
import com.vaadin.flow.theme.lumo.LumoUtility.Width;
import lasalle.edu.co.views.avalconveniosingresounidadesadministrativas.AvalConveniosIngresoUnidadesAdministrativasView;
import lasalle.edu.co.views.formulariotramitarunnuevoconvenio.FormularioTramitarunNuevoConvenioView;
import lasalle.edu.co.views.ingles_avalconveniosingresounidadesadministrativas.Ingles_AvalConveniosIngresoUnidadesAdministrativasView;
import lasalle.edu.co.views.ingles_formulariotramitarunnuevoconvenio2.Ingles_FormularioTramitarunNuevoConvenio2View;
import lasalle.edu.co.views.ingles_ingresorevisarmisconvenios2.Ingles_IngresoRevisarmisConvenios2View;
import lasalle.edu.co.views.ingles_ingresotramitarunnuevoconvenio2.Ingles_IngresoTramitarunNuevoConvenio2View;
import lasalle.edu.co.views.ingles_ingresounidadesadministrativas2.Ingles_IngresoUnidadesAdministrativas2View;
import lasalle.edu.co.views.ingles_nexus.Ingles_NexusView;
import lasalle.edu.co.views.ingles_relacionamientoestratégico.Ingles_RelacionamientoEstratégicoView;
import lasalle.edu.co.views.ingles_revisarmisconvenios2.Ingles_RevisarmisConvenios2View;
import lasalle.edu.co.views.ingles_verconvenios.Ingles_VerConveniosView;
import lasalle.edu.co.views.ingresorevisarmisconvenios.IngresoRevisarmisConveniosView;
import lasalle.edu.co.views.ingresotramitarunnuevoconvenio.IngresoTramitarunNuevoConvenioView;
import lasalle.edu.co.views.ingresounidadesadministrativas.IngresoUnidadesAdministrativasView;
import lasalle.edu.co.views.nexus.NexusView;
import lasalle.edu.co.views.relacionamientoestratégico.RelacionamientoEstratégicoView;
import lasalle.edu.co.views.revisarmisconvenios.RevisarmisConveniosView;
import lasalle.edu.co.views.verconvenios.VerConveniosView;
import org.vaadin.lineawesome.LineAwesomeIcon;

/**
 * The main view is a top-level placeholder for other views.
 */
@Layout
@AnonymousAllowed
public class MainLayout extends AppLayout {

    /**
     * A simple navigation item component, based on ListItem element.
     */
    public static class MenuItemInfo extends ListItem {

        private final Class<? extends Component> view;

        public MenuItemInfo(String menuTitle, Component icon, Class<? extends Component> view) {
            this.view = view;
            RouterLink link = new RouterLink();
            // Use Lumo classnames for various styling
            link.addClassNames(Display.FLEX, Gap.XSMALL, Height.MEDIUM, AlignItems.CENTER, Padding.Horizontal.SMALL,
                    TextColor.BODY);
            link.setRoute(view);

            Span text = new Span(menuTitle);
            // Use Lumo classnames for various styling
            text.addClassNames(FontWeight.MEDIUM, FontSize.MEDIUM, Whitespace.NOWRAP);

            if (icon != null) {
                link.add(icon);
            }
            link.add(text);
            add(link);
        }

        public Class<?> getView() {
            return view;
        }

    }

    public MainLayout() {
        addToNavbar(createHeaderContent());
    }

    private Component createHeaderContent() {
        Header header = new Header();
        header.addClassNames(BoxSizing.BORDER, Display.FLEX, FlexDirection.COLUMN, Width.FULL);

        Div layout = new Div();
        layout.addClassNames(Display.FLEX, AlignItems.CENTER, Padding.Horizontal.LARGE);

        H1 appName = new H1("Nexus-Convenios1");
        appName.addClassNames(Margin.Vertical.MEDIUM, Margin.End.AUTO, FontSize.LARGE);
        layout.add(appName);

        Nav nav = new Nav();
        nav.addClassNames(Display.FLEX, Overflow.AUTO, Padding.Horizontal.MEDIUM, Padding.Vertical.XSMALL);

        // Wrap the links in a list; improves accessibility
        UnorderedList list = new UnorderedList();
        list.addClassNames(Display.FLEX, Gap.SMALL, ListStyleType.NONE, Margin.NONE, Padding.NONE);
        nav.add(list);

        for (MenuItemInfo menuItem : createMenuItems()) {
            list.add(menuItem);

        }

        header.add(layout, nav);
        return header;
    }

    private MenuItemInfo[] createMenuItems() {
        return new MenuItemInfo[]{ //
                new MenuItemInfo("Nexus", LineAwesomeIcon.PENCIL_RULER_SOLID.create(), NexusView.class), //

                new MenuItemInfo("Ingles_Nexus", LineAwesomeIcon.PENCIL_RULER_SOLID.create(), Ingles_NexusView.class), //

                new MenuItemInfo("Relacionamiento Estratégico", LineAwesomeIcon.PENCIL_RULER_SOLID.create(),
                        RelacionamientoEstratégicoView.class), //

                new MenuItemInfo("Ingles_Relacionamiento Estratégico", LineAwesomeIcon.PENCIL_RULER_SOLID.create(),
                        Ingles_RelacionamientoEstratégicoView.class), //

                new MenuItemInfo("Ver Convenios", LineAwesomeIcon.PENCIL_RULER_SOLID.create(), VerConveniosView.class), //

                new MenuItemInfo("Ingles_Ver Convenios", LineAwesomeIcon.PENCIL_RULER_SOLID.create(),
                        Ingles_VerConveniosView.class), //

                new MenuItemInfo("Ingreso Tramitar un Nuevo Convenio", LineAwesomeIcon.PENCIL_RULER_SOLID.create(),
                        IngresoTramitarunNuevoConvenioView.class), //

                new MenuItemInfo("Ingles_Ingreso Tramitar un Nuevo Convenio2",
                        LineAwesomeIcon.PENCIL_RULER_SOLID.create(), Ingles_IngresoTramitarunNuevoConvenio2View.class), //

                new MenuItemInfo("Formulario Tramitar un Nuevo Convenio", LineAwesomeIcon.PENCIL_RULER_SOLID.create(),
                        FormularioTramitarunNuevoConvenioView.class), //

                new MenuItemInfo("Ingles_ Formulario Tramitar un Nuevo Convenio2",
                        LineAwesomeIcon.PENCIL_RULER_SOLID.create(),
                        Ingles_FormularioTramitarunNuevoConvenio2View.class), //

                new MenuItemInfo("Ingreso Revisar mis Convenios", LineAwesomeIcon.PENCIL_RULER_SOLID.create(),
                        IngresoRevisarmisConveniosView.class), //

                new MenuItemInfo("Ingles_Ingreso Revisar mis Convenios2", LineAwesomeIcon.PENCIL_RULER_SOLID.create(),
                        Ingles_IngresoRevisarmisConvenios2View.class), //

                new MenuItemInfo("Revisar mis Convenios", LineAwesomeIcon.PENCIL_RULER_SOLID.create(),
                        RevisarmisConveniosView.class), //

                new MenuItemInfo("Ingles_Revisar mis Convenios2", LineAwesomeIcon.PENCIL_RULER_SOLID.create(),
                        Ingles_RevisarmisConvenios2View.class), //

                new MenuItemInfo("Ingreso Unidades Administrativas", LineAwesomeIcon.PENCIL_RULER_SOLID.create(),
                        IngresoUnidadesAdministrativasView.class), //

                new MenuItemInfo("Ingles_Ingreso Unidades Administrativas2",
                        LineAwesomeIcon.PENCIL_RULER_SOLID.create(), Ingles_IngresoUnidadesAdministrativas2View.class), //

                new MenuItemInfo("Aval Convenios Ingreso Unidades Administrativas",
                        LineAwesomeIcon.PENCIL_RULER_SOLID.create(),
                        AvalConveniosIngresoUnidadesAdministrativasView.class), //

                new MenuItemInfo("Ingles_Aval Convenios Ingreso Unidades Administrativas",
                        LineAwesomeIcon.PENCIL_RULER_SOLID.create(),
                        Ingles_AvalConveniosIngresoUnidadesAdministrativasView.class), //

        };
    }

}
