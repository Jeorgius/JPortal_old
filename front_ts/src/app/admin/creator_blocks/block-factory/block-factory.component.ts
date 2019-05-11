import {
  Component,
  ComponentFactoryResolver,
  ComponentRef,
  Input,
  OnInit,
  ViewChild,
  ViewContainerRef
} from '@angular/core';
import {Type} from "@angular/core/src/type";

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
  @ViewChild('AddBlock',{read: ViewContainerRef}) newBlock :ViewContainerRef;
  constructor(private resolver :ComponentFactoryResolver) { }
  ngOnInit() {}


  get blockType(): string {
    return this._blockType;
  }

  /**
   * Generate component based on block type
   * @param value - block type as string. Set as an input that is caught from svg-element
   */
  @Input()
  set blockType(value: string) {
    this._blockType = value;

    if(!this._blockType) return;
    //if(this.newBlock) this.newBlock.clear();

    /**
     * Get proper component
     * Get array of factories from ComponentFactoryResolver
     * Find a component that matches svg name, for instance,
     * textOnly gets transformed into TextOnlyComponent
     */
    this.newBlock.createComponent(
      this.resolver.resolveComponentFactory(
        <Type<any>>(Array
          .from(this.resolver["_factories"].keys()))
          .find((component:any) =>
              component.name === value.charAt(0).toUpperCase()+value.slice(1)+"Component"
          )
      )
    );
  }

}
