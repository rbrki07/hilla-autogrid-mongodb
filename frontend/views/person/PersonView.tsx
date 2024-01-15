import { VerticalLayout } from "@hilla/react-components/VerticalLayout.js";
import { AutoGrid } from "@hilla/react-crud";
import PersonModel from "Frontend/generated/com/example/application/entities/PersonModel";
import { PersonService } from "Frontend/generated/endpoints";

export default function PersonView() {
  return (
    <VerticalLayout className="h-full">
      <AutoGrid service={PersonService} model={PersonModel} />
    </VerticalLayout>
  )
}
