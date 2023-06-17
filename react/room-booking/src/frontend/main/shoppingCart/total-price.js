import React, { Component } from 'react';
import { Button, Stack } from 'react-bootstrap';
import PayMethod from './totalPrice/pay-method';

class TotalPrice extends Component {

    render() {

        const borderStyle = {
            padding : '3rem 3rem 2rem'
        };
        const setter = {
            payMethod : {
                setPayMethod : (colVal, onSet) => this.setter('payMethod', colVal, onSet)
            }
        };
        const getter = {
            payMethod : {
                getPayMethod : () => this.getter('payMethod')
            }
        };
        

        return (
            <div className='border border-1 border-secondary rounded-2 rounded' style={borderStyle}>
                <Stack gap={5}>
                    <Stack direction='horizontal'>
                        <h3>總價</h3>
                        <h2 className='text-secondary ms-auto'>
                            $ <span>{this.getter('totalPrice')}</span> 元
                        </h2>
                    </Stack>
                    <PayMethod setter={setter.payMethod} getter={getter.payMethod} />
                    <Button variant='outline-primary' onClick={this.onClickCheckoutBtn}>結帳</Button>
                </Stack>
            </div>
        );
    }

    // on
    onClickCheckoutBtn = (event) => {

        const {fctn} = this.props;
        const showCreditCard = this.getter('payMethod').showCreditCard;
        let pass = true;

        if(showCreditCard){

            pass = this.checkCardNumber(() => {

                pass = this.checkValidation() && pass;
            }) && pass;
        }
        
        if(pass){

            fctn.showConfirmModal('確定要結帳 ? ', () => {

                fctn.closeConfirmModal();
                fctn.checkout();
            });
        }
    };


    // other
    checkCardNumber = (onClickOkBtn) => {

        const {fctn} = this.props;
        const cardNumber1 = this.getter('payMethod').creditCard.cardNumber.value1;
        const cardNumber2 = this.getter('payMethod').creditCard.cardNumber.value2;
        const cardNumber3 = this.getter('payMethod').creditCard.cardNumber.value3;
        const cardNumber4 = this.getter('payMethod').creditCard.cardNumber.value4;

        if(cardNumber1 === '' || cardNumber2 === '' || cardNumber3 === '' || cardNumber4 === ''){
    
            
            fctn.showInformModal('信用卡卡號未輸入完整', () => {

                fctn.closeInformModal();
                onClickOkBtn && onClickOkBtn();
            });
            return false;
        }else if(cardNumber1.length !== 3 || cardNumber2.length !== 3 || 
            cardNumber3.length !== 3 || cardNumber4.length !== 3){

            fctn.showInformModal('信用卡卡號格式錯誤', () => {

                fctn.closeInformModal();
                onClickOkBtn && onClickOkBtn();
            });
            return false;
        }else{

            onClickOkBtn && onClickOkBtn();
            return true;
        }
    };
    checkValidation = (onClickOkBtn) => {

        const {fctn} = this.props;
        const validation = this.getter('payMethod').creditCard.validation.value;
    
        if(validation === ''){
    
            fctn.showInformModal('信用卡檢核碼未輸入', () => {

                fctn.closeInformModal();
                onClickOkBtn && onClickOkBtn();
            });
            return false;
        }else if(validation.length !== 3){

            fctn.showInformModal('信用卡檢核碼格式錯誤', () => {

                fctn.closeInformModal();
                onClickOkBtn && onClickOkBtn();
            });
            return false;
        }else{
            
            onClickOkBtn && onClickOkBtn();
            return true;
        }
    };


    // setter getter
    setter = (colName, colVal, onSet) => {

        const {setter, getter} = this.props;

        setter.setTotalPrice({
            ...getter.getTotalPrice(),
            [colName] : colVal
        }, onSet);
    };
    getter = (colName) => {

        const {getter} = this.props;
        return getter.getTotalPrice()[colName];
    }
}

export default TotalPrice;