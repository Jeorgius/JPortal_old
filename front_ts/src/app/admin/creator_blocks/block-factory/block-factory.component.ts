import {
  Component,
  ComponentFactoryResolver,
  ComponentRef,
  Input,
  OnInit,
  ViewChild,
  ViewContainerRef, ViewRef
} from '@angular/core';
import {Type} from "@angular/core/src/type";
import {Block} from "./block";

@Component({
  selector: 'block-factory',
  templateUrl: './block-factory.component.html',
  styleUrls: ['./block-factory.component.scss']
})
export class BlockFactoryComponent implements OnInit {

  //<editor-fold defaultstate="collapsed" desc="Name of the block. Incoming parameter">
  //</editor-fold>
  private _blockType: string = "";
  private componentRef: any;

  /**
   * Attached HTML-element to render component
   * @ViewChild - generated block in which component is added
   * 1 - string, 'Addblock' - HTML container element
   * 2 - ViewContainerRef - where to put it
   */
  @ViewChild('AddBlock',{read: ViewContainerRef}) blockContainer :ViewContainerRef;
  constructor(private resolver :ComponentFactoryResolver) { }
  ngOnInit() {}


  get blockType(): string {
    return this._blockType;
  }

  /**
   * Generate component based on block type
   * @param blockType - block type as string. Set as an input that is caught from svg-element
   */
  @Input()
  set blockType(blockType: string) {
    this._blockType = blockType;

    if(!this._blockType) return;

    /**
     * Get proper component
     * Get array of factories from ComponentFactoryResolver
     * Find a component that matches svg name, for example,
     * textOnly gets transformed into TextOnlyComponent
     */
    let newBlock = this.blockContainer.createComponent(
      this.resolver.resolveComponentFactory(
        <Type<any>>(Array
          .from(this.resolver["_factories"].keys()))
          .find((component:any) =>
              component.name === blockType.charAt(0).toUpperCase()+blockType.slice(1)+"Component"
          )
      )
    );
    /**
     * Set an id of component as id = component+index
     * for example, fRight1
     */
    newBlock.instance.index = this.blockContainer.indexOf(<ViewRef><unknown>newBlock);
  }

}
