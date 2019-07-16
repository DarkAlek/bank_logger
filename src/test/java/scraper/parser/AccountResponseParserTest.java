package scraper.parser;

import com.gargoylesoftware.htmlunit.WebResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

public class AccountResponseParserTest {

  @Mock
  private WebResponse passwordResponse;
  private JSONObject testAccountsList;

  @Before
  public void init() throws ParseException {
    MockitoAnnotations.initMocks(this);
    Mockito.when(passwordResponse.getContentAsString()).thenReturn("{\"standard_session\": {\"absolute_timeout\": 3600, \"is_user_logged_in\": true, \"system_timestamp\": \"2019-06-28 13:51:45\", \"absolute_timeout_left\": 3589, \"lifetime\": 300}, \"system\": {\"mode\": \"ONLINE\"}, \"globals\": {\"splash_screen_campaigns\": {\"reset\": true}, \"credit_offers\": {\"reset\": true, \"removed\": [], \"added\": [{\"_item_id\": \"1\", \"curr\": \"PLN\", \"product_group_code\": \"5050\", \"amount\": \"10000\", \"feeplan\": \"MOBILE\", \"is_special_offer\": true, \"special_offer_description\": \"Zam\\u00f3w kontakt, aby pozna\\u0107 szczeg\\u00f3\\u0142y\", \"marketing_text\": \"Zostaw kontakt, a oddzwonimy do Ciebie i zaproponujemy najlepsz\\u0105 ofert\\u0119.\", \"product_name\": \"Po\\u017cyczka got\\u00f3wkowa\"}], \"changed\": []}, \"paycards\": {\"reset\": true, \"removed\": [], \"added\": [{\"_item_id\": \"9e4840115857f6ca95521ac0a5b9ae782663d10b053858724e51f9807a92b415\", \"curr\": \"PLN\", \"card_limit_max\": {\"curr\": \"PLN\", \"value\": \"10000000\"}, \"embossed_name\": \"\", \"holder_name\": \"ALEKSY MI\\u015aTAL\", \"is_paycard_owner\": true, \"account_name\": \"Konto Freemium\", \"layout_url\": \"https://static.t-mobilebankowe.pl/uploads/files/www/cardLayout_540_standard.png\", \"fee\": {\"fee_waiver_description\": \"Zwolniono z miesi\\u0119cznej op\\u0142aty za kart\\u0119\", \"fee_waived\": true}, \"block_color\": \"#317CB3\", \"credit_actual_use\": {\"curr\": \"PLN\", \"value\": \"0\"}, \"priority\": 69798292860465, \"expire_date\": \"2020-08-31\", \"status\": \"ACTIVE\", \"mcm\": {\"status\": \"ACTIVE\"}, \"paycard_account_ownership\": \"OWNER\", \"sec_code_avail\": true, \"card_description\": \"Karta debetowa Mastercard\", \"background\": {\"url\": \"static/images/backgrounds/06.karta_debetowa.png\"}, \"multicurrency\": {\"status\": \"NOT-ACTIVE\", \"has_ability\": false}, \"permissions\": {\"can_paycard_installments\": false, \"can_transfer_as_src\": true, \"can_enable_apple_pay\": false, \"can_modify_limits\": true, \"can_transfer\": false, \"can_disable_apple_pay\": false, \"can_increase_limits\": true, \"can_transfer_as_dst\": false, \"can_enable_hce\": false, \"can_change_pin\": true, \"can_repay\": false, \"can_enable_google_pay\": false, \"can_view_statement\": false, \"mastercardpriceless_available\": false, \"can_activate\": false, \"can_secure_data_get\": true, \"can_disable_hce\": false, \"can_disable_google_pay\": false}, \"card_type_descr\": \"Karta debetowa Mastercard\", \"account\": \"632490000000000000\", \"cashback_availability\": false, \"product_type\": \"DEBIT\", \"show_expire_warning\": false, \"limits\": [{\"pos_card\": {\"max\": \"25000\"}, \"pos_no_card\": {\"max\": \"25000\"}, \"atm\": {\"max\": \"15000\"}, \"curr\": \"PLN\", \"pos_no_pin\": {\"max\": \"25000\"}}], \"holder_cif\": \"94327144\", \"card_bin\": \"510259\", \"card_id\": \"9e4840115857f6ca95521ac0a5b9ae782663d10b053858724e51f9807a92b415\", \"card_type\": \"DD\", \"min_payment_date\": \"2019-06-28\", \"font_color\": \"#000000\", \"balance\": {\"curr\": \"PLN\", \"value\": \"5.81\"}, \"card_number\": \"5102 59** **** 0465\", \"delivery_date\": \"2017-07-13\"}], \"changed\": []}, \"contexts\": {\"reset\": true, \"removed\": [], \"added\": [{\"login_id\": \"94327144\", \"_item_id\": \"0\", \"can_sso_token_create\": false, \"description\": \"ALEKSY MI\\u015aTAL\", \"context_type\": \"OWNER\", \"context_id\": \"94327144\", \"selected\": true, \"context_kind\": \"PERSON\", \"can_change_context\": true, \"can_change_default_account\": true, \"context_permissions\": {\"can_create_standing_order_own\": true, \"can_update_card_limit\": true, \"credit_repayment_schedule_available\": true, \"can_prepaid_topup_invoice_order\": true, \"can_transfer_normal_own\": true, \"can_change_residence_address\": false, \"can_change_account_name\": true, \"brokerage_accounts_available\": true, \"can_p2p_transfer_email\": true, \"account_details_available\": true, \"tpp_consents_available\": true, \"can_enable_auto_repayment\": true, \"can_masterpass_tx_auth\": false, \"paycard_account_history_available\": true, \"standing_order_available\": true, \"correspondence_address_available\": true, \"credit_details_available\": true, \"popup_notifications_available\": true, \"auto_repayment_available\": true, \"can_change_trusted_phone_number\": true, \"can_payment_template_modify\": true, \"can_create_investment_order\": true, \"new_investment_available\": true, \"can_close_deposit_negotiated\": true, \"can_inbox_modify\": true, \"payment_templates_available\": true, \"registers_available\": true, \"credit_account_details_available\": true, \"deferred_transfer_available\": true, \"prepaid_topup_rules_available\": true, \"can_delete_transfer_own\": true, \"masterpass_available\": false, \"can_p2p_transfer_phone\": true, \"account_open_ro_application\": true, \"can_modify_transfer_normal\": true, \"can_change_invoice_data\": true, \"can_transfer_own\": true, \"can_history_export\": true, \"can_activate_auto_repayment\": true, \"document_list_available\": true, \"can_modify_deposit_negotiated\": true, \"can_deferred_transfer_delete\": true, \"notifications_system_available\": true, \"recommendation_program_invitations_available\": true, \"can_delete_topup_template\": true, \"one_time_topup_available\": true, \"can_modify_mastercardpriceless\": false, \"credit_history_available\": true, \"can_create_topup_template\": true, \"global_search_available\": true, \"loan_paycard_order\": false, \"can_modify_prepaid_topup_rules\": true, \"can_disable_marketing_agreements\": true, \"credit_card_application\": true, \"can_open_deposit_negotiated\": true, \"master_pass_settings\": true, \"can_modify_transfer_own\": true, \"can_trusted_payment_template_delete\": true, \"can_transfer_limits_modify\": true, \"prepaid_topup_available\": true, \"investment_funds_available\": true, \"can_change_official_address\": true, \"balance_autofill_available\": true, \"can_mcm_mp_disable\": true, \"can_paycard_transfer\": true, \"can_transfer_foreign\": true, \"can_trusted_payment_template_create\": true, \"can_delete_transfer_foreign\": true, \"recommendation_program_bonus_condition_available\": true, \"can_payu_express\": true, \"paycard_application\": true, \"can_delete_paycard_transfer\": true, \"can_delete_transfer_us\": true, \"products_available\": true, \"can_delete_prepaid_topup_rules\": true, \"can_renewed\": true, \"can_masterpass_disable\": false, \"can_change_account_statement_period_type\": true, \"deposit_negotiated_available\": true, \"deposit_standard_available\": true, \"can_change_login_method\": true, \"account_history_hold_available\": true, \"can_paycard_auto_repayment_disable\": true, \"can_activate_paycard\": true, \"context_available\": true, \"credit_repayment\": true, \"notifications_available\": true, \"can_buy_investment_fund\": true, \"can_transfer_nfc\": true, \"can_deferred_transfer_modify\": true, \"can_disable_hce\": false, \"can_transfer_request_money_qr\": true, \"deposit_standard_details_available\": true, \"push_notifications_available\": true, \"forex_accounts_available\": true, \"can_delete_standing_order_own\": true, \"can_paycard_block\": true, \"account_open_ror_application\": true, \"recommendation_program_statistics_available\": true, \"credits_available\": true, \"can_change_email\": true, \"recommendation_program_available\": true, \"500plus_available\": false, \"recommendation_program_product_list_available\": true, \"can_enable_hce\": false, \"can_cancel_p2p_hold\": true, \"can_change_mcm_mp_pin\": true, \"payments_available\": true, \"leads_available\": true, \"can_register_to_recommendation_program\": true, \"credit_payout_schedule_available\": true, \"can_one_time_topup_tmpl\": true, \"settings_available\": true, \"can_change_default_profile\": true, \"can_change_alias\": true, \"event_register_available\": true, \"can_transfer_immediate\": true, \"can_modify_paycard_auto_repayment\": true, \"auto_repayment_invoice_available\": true, \"can_paycard_repayment\": true, \"money_box_available\": true, \"can_show_cvc2\": true, \"can_delete_transfer_zus\": true, \"can_money_box_close\": true, \"personal_settings_available\": true, \"can_paycard_unblock\": true, \"official_address_available\": true, \"can_change_client_data\": false, \"can_paycard_auto_repayment_enable\": true, \"can_mcm_mp_enable\": true, \"can_paycard_restrict\": true, \"can_paycard_close\": true, \"can_request_money\": true, \"nfc_card_application\": true, \"can_response\": true, \"can_deactivate_auto_repayment\": true, \"marketing_agreements_available\": true, \"dobry_start_available\": false, \"can_trusted_devices_modify\": true, \"investment_applications_available\": true, \"can_change_account_statement_delivery_type\": true, \"moneymakers_accounts_available\": true, \"can_update_paycard_limits\": true, \"can_one_time_topup_bm\": true, \"can_create_standing_order\": true, \"account_statements_available\": true, \"can_masterpass_enable\": false, \"can_modify_transfer_foreign\": true, \"questionnaires_available\": true, \"auto_repayment_payment_id_list_available\": true, \"transfer_limits_available\": true, \"can_modify_standing_order\": true, \"can_modify_standing_order_own\": true, \"campaign_available\": true, \"invoice_available\": true, \"can_delete_transfer_normal\": true, \"paycards_available\": true, \"inbox_available\": true, \"trusted_devices_available\": true, \"can_change_paycard_pin\": true, \"investment_list_available\": true, \"can_change_cc_password\": false, \"can_payment_template_create\": true, \"can_masterpass_card_add\": false, \"can_enable_apple_pay\": false, \"profile_available\": true, \"paycard_details_available\": true, \"mobile_operator_agreements_available\": true, \"can_change_auth_method\": true, \"can_auto_repayment_agreements_modify\": true, \"lor_application\": true, \"personalization_available\": true, \"investment_wallet_available\": true, \"can_open_deposit_standard\": true, \"can_disable_pos_no_pin\": true, \"accounts_available\": true, \"can_transfer_zus\": false, \"can_modify_transfer_us\": true, \"exchange_trade_products_available\": true, \"credit_card_account_details\": true, \"notifications_config\": true, \"can_assign_anti_phishing_image\": true, \"account_history_available\": true, \"transaction_confirmation\": true, \"can_create_exchange_trade\": true, \"can_modify_transfer_zus\": false, \"investment_offers_available\": true, \"can_delete_standing_order\": true, \"can_auto_repayment_register\": true, \"residence_address_available\": true, \"can_update_paycard_status\": true, \"can_change_default_account\": true, \"can_balance_autofill_modify\": true, \"can_change_mcm_mp_phone_number\": true, \"lead_application\": true, \"can_disable_google_pay\": false, \"can_disable_auto_repayment\": true, \"can_money_box_open\": true, \"can_change_product_order\": true, \"can_transfer_pay_by_link\": true, \"credit_account_paycard_details_available\": true, \"can_money_box_modify\": true, \"can_transfer_normal\": true, \"can_transfer_waiting\": true, \"split_payment_available\": false, \"can_change_correspondence_address\": true, \"security_settings_available\": true, \"fatca_available\": false, \"can_enable_google_pay\": false, \"can_disable_pos_no_card\": true, \"can_trusted_payment_template_modify\": true, \"can_modify_topup_template\": true, \"can_modify_deposit_standard\": true, \"can_masterpass_card_remove\": false, \"ext_session_available\": false, \"paycard_account_available\": true, \"can_payment_template_delete\": true, \"can_create_prepaid_topup_rules\": true, \"eoffice_available\": false, \"can_enable_pos_no_pin\": true, \"can_disable_apple_pay\": false, \"blik_settings\": true, \"can_blik_enable\": true, \"can_paycard_installments\": true, \"can_modify_personal_settings\": true, \"channel_list_available\": true, \"blik_available\": true, \"can_enable_marketing_agreements\": true, \"paycard_statements_available\": true, \"can_blik_disable\": true, \"can_recommend_product\": true, \"payment_basket_available\": true, \"can_close_deposit_standard\": true, \"can_enable_pos_no_card\": true, \"topup_templates_available\": true, \"can_modify_paycard_transfer\": true, \"topup_history_list\": true, \"can_transfer_us\": true}, \"order\": 0}], \"changed\": []}, \"settings\": {\"blik_account\": \"6324324323\", \"default_context\": \"94327144\", \"blik_fast_payments_enabled\": true, \"preauth_balance\": {\"total_amount\": \"50000.00\", \"format\": \"AMOUNT\"}, \"inapp_widget\": \"NOT-ACTIVE\", \"main_product\": {\"account\": \"632490000000000000\"}, \"product_group_order\": [{\"curr\": \"PLN\", \"type\": \"ACCOUNTS\", \"sub_type\": \"ROR\"}], \"blik_status\": \"ACTIVE\", \"default_account\": \"434324324324324324\", \"permissions\": {\"can_set_inapp_widget\": true}}, \"deposits\": {\"reset\": true, \"summary\": {}}, \"credit_card_accounts\": {\"reset\": true, \"summary\": {\"loan\": {}, \"mortgage\": {}}}, \"leads\": {\"reset\": true, \"removed\": [], \"added\": [{\"_item_id\": \"4\", \"title\": \"Konto oszcz\\u0119dno\\u015bciowe\", \"button\": \"Otw\\u00f3rz konto\", \"description_lines\": [\"\\u2022 Oprocentowanie 1,5% na koncie w PLN, gdy przelewasz wynagrodzenie\", \"\\u2022 0 z\\u0142 za prowadzenie konta\"], \"type\": \"SAVINGS-ACCOUNT-APPLICATION\", \"promotion_condition\": {\"button_label\": \"Nota prawna\", \"text\": \"Oprocentowanie 1,5% w ramach promocji, dotyczy Rachunk\\u00f3w Oszcz\\u0119dno\\u015bciowych, kt\\u00f3rych w\\u0142a\\u015bciciel posiada rachunek oszcz\\u0119dno\\u015bciowo \\u2013 rozliczeniowy w wariancie Konto Freemium lub Konto Premium, na kt\\u00f3rym w poprzednim miesi\\u0105cu kalendarzowym odnotowano wp\\u0142yw z tytu\\u0142u wynagrodzenia dokonany przez pracodawc\\u0119 b\\u0105d\\u017a wp\\u0142yw z tytu\\u0142u stypendium dokonany przez uczelni\\u0119 wy\\u017csz\\u0105 b\\u0105d\\u017a wp\\u0142yw z tytu\\u0142u renty lub emerytury dokonany przez ZUS; w przeciwnym wypadku, oprocentowanie wynosi WIBID 1M \\u2013 0,4 p.p.. Promocja obowi\\u0105zuje od 1 stycznia 2019 r. do 30 czerwca 2019 r. Oprocentowaniem 1,5% mo\\u017ce zosta\\u0107 obj\\u0119ty wy\\u0142\\u0105cznie jeden Rachunek Oszcz\\u0119dno\\u015bciowy. W przypadku posiadania wi\\u0119cej ni\\u017c jednego Rachunku Oszcz\\u0119dno\\u015bciowego promocj\\u0105 zostanie obj\\u0119ty Rachunek Oszcz\\u0119dno\\u015bciowy o najwcze\\u015bniejszej dacie otwarcia. W przypadku nowych Rachunk\\u00f3w oszcz\\u0119dno\\u015bciowych oprocentowanie promocyjne ma zastosowanie od dnia nast\\u0119puj\\u0105cego po dacie otwarcia rachunku.\"}, \"details_button\": {\"label\": \"Szczeg\\u00f3\\u0142y\", \"url\": \"https://www.t-mobilebankowe.pl/konto-oszczednosciowe\"}}], \"changed\": []}, \"credits\": {\"reset\": true, \"summary\": {\"loan\": {}, \"mortgage\": {}}}, \"accounts\": {\"reset\": true, \"added\": [{\"limit_used\": \"0\", \"_item_id\": \"632490\", \"curr\": \"PLN\", \"account_icon\": \"127\", \"color\": \"#1063AD\", \"number\": \"4324324324324324\", \"product_code\": \"4200\", \"ownership_type\": \"OWNER\", \"account_name\": \"Konto Freemium\", \"product_code_description\": \"Konto Freemium\", \"limit_available\": \"0.00\", \"positive_interest\": {\"rate\": \"0.00\"}, \"open_date\": \"2096-18-42\", \"statement_frequency\": {}, \"status\": \"ACTIVE\", \"owner_name\": \"ALEKSY  MI\\u015aTAL\", \"account_category_description\": \"Rachunek oszcz\\u0119dno\\u015bciowo-rozliczeniowy\", \"is_default\": true, \"background\": {\"url\": \"static/images/backgrounds/01.konto_freemium.png\"}, \"permissions\": {\"source_name_required\": false, \"can_register_recommendation_program\": true, \"can_deposit_open\": true, \"can_sp_transfer\": false, \"can_overdraft_limit_order\": true, \"can_receive_interest\": true, \"can_money_box_open\": true}, \"ownership_type_desc\": \"W\\u0142a\\u015bciciel\", \"cashback_availability\": false, \"fee_plan\": \"IRR00\", \"account_category\": \"ROR\", \"overdraft_limit\": \"0.00\", \"hold_amount\": \"98.15\", \"balance\": {\"avail\": \"5.81\", \"ledger\": \"103.96\"}}], \"changed\": [], \"removed\": [], \"summary\": {\"ror\": {}, \"ro\": {}}, \"account_offer\": {\"ror\": [{\"_item_id\": \"IRR00\", \"curr\": [\"PLN\"], \"name\": \"Konto Freemium\", \"fee_plan\": \"IRR00\", \"deponent_info\": {\"url\": \"https://static.t-mobilebankowe.pl/uploads/files/arkusz_informacyjny_dla_deponentow.pdf\", \"content\": \"Informujemy, \\u017ce \\u015brodki pieni\\u0119\\u017cne zgromadzone na rachunkach bankowych prowadzonych przez Bank w tym rachunkach prowadzonych w ramach T-Mobile Us\\u0142ugi Bankowe dostarczane przez Alior Bank, Alior Bank S.A, Kantor Walutowy oraz Alior Bank S.A. Var\\u0219ovia- Sucursala Bucure\\u0219ti s\\u0105 obj\\u0119te systemem gwarantowania depozyt\\u00f3w na zasadach okre\\u015blonych w ustawie z dnia 10 czerwca 2016 r. o Bankowym Funduszu Gwarancyjnym, systemie gwarantowania depozyt\\u00f3w oraz przymusowej restrukturyzacji przy czym dla jednego Posiadacza ochrona gwarancyjna jest ograniczona do \\u015brodk\\u00f3w w wysoko\\u015bci r\\u00f3wnowarto\\u015bci w z\\u0142otych 100 000 euro. Zapoznaj si\\u0119 z tre\\u015bci\\u0105 ca\\u0142ej informacji\"}, \"available_paycards\": [\"DD\", \"DN\", \"FD\", \"DP\"], \"product_type\": \"4200\", \"presentation_lines\": [\"0 z\\u0142 za prowadzenie konta i krajowe przelewy internetowe oraz bankowo\\u015b\\u0107 internetow\\u0105 i mobiln\\u0105\", \"0 z\\u0142 za kart\\u0119 do konta, przy rozliczeniu transakcji kart\\u0105 za jedyne 200 z\\u0142 miesi\\u0119cznie\"], \"graphic_url\": \"https://static.t-mobilebankowe.pl/uploads/files/KontoFreemium.jpg\"}, {\"_item_id\": \"IRR01\", \"curr\": [\"PLN\"], \"name\": \"Konto Premium\", \"fee_plan\": \"IRR01\", \"deponent_info\": {\"url\": \"https://static.t-mobilebankowe.pl/uploads/files/arkusz_informacyjny_dla_deponentow.pdf\", \"content\": \"Informujemy, \\u017ce \\u015brodki pieni\\u0119\\u017cne zgromadzone na rachunkach bankowych prowadzonych przez Bank w tym rachunkach prowadzonych w ramach T-Mobile Us\\u0142ugi Bankowe dostarczane przez Alior Bank, Alior Bank S.A, Kantor Walutowy oraz Alior Bank S.A. Var\\u0219ovia- Sucursala Bucure\\u0219ti s\\u0105 obj\\u0119te systemem gwarantowania depozyt\\u00f3w na zasadach okre\\u015blonych w ustawie z dnia 10 czerwca 2016 r. o Bankowym Funduszu Gwarancyjnym, systemie gwarantowania depozyt\\u00f3w oraz przymusowej restrukturyzacji przy czym dla jednego Posiadacza ochrona gwarancyjna jest ograniczona do \\u015brodk\\u00f3w w wysoko\\u015bci r\\u00f3wnowarto\\u015bci w z\\u0142otych 100 000 euro. Zapoznaj si\\u0119 z tre\\u015bci\\u0105 ca\\u0142ej informacji\"}, \"available_paycards\": [\"DD\", \"DN\", \"FD\", \"DP\"], \"product_type\": \"4200\", \"presentation_lines\": [\"0 z\\u0142 za krajowe przelewy internetowe oraz bankowo\\u015b\\u0107 internetow\\u0105 i mobiln\\u0105\", \"0 z\\u0142 za wyp\\u0142aty z dowolnego bankomatu w Polsce i na \\u015bwiecie i nieograniczon\\u0105 liczb\\u0119 wp\\u0142at we wp\\u0142atomatach w miesi\\u0105cu\", \"0 z\\u0142 za konto przy rozliczeniu transakcji kart\\u0105 za jedyne 500 z\\u0142\"], \"graphic_url\": \"https://static.t-mobilebankowe.pl/uploads/files/KontoPremium.jpg\"}, {\"_item_id\": \"IRW00\", \"curr\": [\"EUR\", \"USD\", \"GBP\", \"CHF\"], \"name\": \"T-Mobile konto walutowe\", \"fee_plan\": \"IRW00\", \"deponent_info\": {\"url\": \"https://static.t-mobilebankowe.pl/uploads/files/arkusz_informacyjny_dla_deponentow.pdf\", \"content\": \"Informujemy, \\u017ce \\u015brodki pieni\\u0119\\u017cne zgromadzone na rachunkach bankowych prowadzonych przez Bank w tym rachunkach prowadzonych w ramach T-Mobile Us\\u0142ugi Bankowe dostarczane przez Alior Bank, Alior Bank S.A, Kantor Walutowy oraz Alior Bank S.A. Var\\u0219ovia- Sucursala Bucure\\u0219ti s\\u0105 obj\\u0119te systemem gwarantowania depozyt\\u00f3w na zasadach okre\\u015blonych w ustawie z dnia 10 czerwca 2016 r. o Bankowym Funduszu Gwarancyjnym, systemie gwarantowania depozyt\\u00f3w oraz przymusowej restrukturyzacji przy czym dla jednego Posiadacza ochrona gwarancyjna jest ograniczona do \\u015brodk\\u00f3w w wysoko\\u015bci r\\u00f3wnowarto\\u015bci w z\\u0142otych 100 000 euro. Zapoznaj si\\u0119 z tre\\u015bci\\u0105 ca\\u0142ej informacji\"}, \"available_paycards\": [\"DD\", \"DN\", \"FD\", \"DP\"], \"product_type\": \"4200\", \"presentation_lines\": [\"bezp\\u0142atne konto w wybranej przez Ciebie walucie\", \"dost\\u0119pne waluty: EUR, CHF, GBP, USD\"], \"graphic_url\": \"https://static.t-mobilebankowe.pl/uploads/files/KontoWalutowe.jpg\"}], \"ro\": [{\"_item_id\": \"IKO00\", \"curr\": [\"PLN\"], \"name\": \"Konto oszcz\\u0119dno\\u015bciowe\", \"fee_plan\": \"IKO00\", \"deponent_info\": {\"url\": \"https://static.t-mobilebankowe.pl/uploads/files/arkusz_informacyjny_dla_deponentow.pdf\", \"content\": \"Informujemy, \\u017ce \\u015brodki pieni\\u0119\\u017cne zgromadzone na rachunkach bankowych prowadzonych przez Bank w tym rachunkach prowadzonych w ramach T-Mobile Us\\u0142ugi Bankowe dostarczane przez Alior Bank, Alior Bank S.A, Kantor Walutowy oraz Alior Bank S.A. Var\\u0219ovia- Sucursala Bucure\\u0219ti s\\u0105 obj\\u0119te systemem gwarantowania depozyt\\u00f3w na zasadach okre\\u015blonych w ustawie z dnia 10 czerwca 2016 r. o Bankowym Funduszu Gwarancyjnym, systemie gwarantowania depozyt\\u00f3w oraz przymusowej restrukturyzacji przy czym dla jednego Posiadacza ochrona gwarancyjna jest ograniczona do \\u015brodk\\u00f3w w wysoko\\u015bci r\\u00f3wnowarto\\u015bci w z\\u0142otych 100 000 euro. Zapoznaj si\\u0119 z tre\\u015bci\\u0105 ca\\u0142ej informacji\"}, \"interest_info\": \"Oprocentowanie konta oszcz\\u0119dno\\u015bciowego jest zmienne, co wi\\u0105\\u017ce si\\u0119 z ryzykiem spadku lub wzrostu wysoko\\u015bci otrzymanego zysku. Informacja o oprocentowaniu dost\\u0119pna w <a href=\\\"https://static.t-mobilebankowe.pl/uploads//files//TabelaOprocentowania.pdf\\\"> Tabeli Oprocentowania</a>.\", \"available_paycards\": [\"DD\", \"DP\"], \"product_type\": \"4300\", \"presentation_lines\": [\"Oprocentowanie 1,5% dla salda do 50.000 z\\u0142, gdy przelewasz wynagrodzenie\", \"0 z\\u0142 za prowadzenie konta\"], \"graphic_url\": \"https://static.t-mobilebankowe.pl/uploads/files/KontoOszczednosciowe.jpg\"}, {\"_item_id\": \"IKW00\", \"curr\": [\"EUR\", \"USD\", \"GBP\", \"CHF\"], \"name\": \"Konto oszcz\\u0119dno\\u015bciowe walutowe\", \"fee_plan\": \"IKW00\", \"deponent_info\": {\"url\": \"https://static.t-mobilebankowe.pl/uploads/files/arkusz_informacyjny_dla_deponentow.pdf\", \"content\": \"Informujemy, \\u017ce \\u015brodki pieni\\u0119\\u017cne zgromadzone na rachunkach bankowych prowadzonych przez Bank w tym rachunkach prowadzonych w ramach T-Mobile Us\\u0142ugi Bankowe dostarczane przez Alior Bank, Alior Bank S.A, Kantor Walutowy oraz Alior Bank S.A. Var\\u0219ovia- Sucursala Bucure\\u0219ti s\\u0105 obj\\u0119te systemem gwarantowania depozyt\\u00f3w na zasadach okre\\u015blonych w ustawie z dnia 10 czerwca 2016 r. o Bankowym Funduszu Gwarancyjnym, systemie gwarantowania depozyt\\u00f3w oraz przymusowej restrukturyzacji przy czym dla jednego Posiadacza ochrona gwarancyjna jest ograniczona do \\u015brodk\\u00f3w w wysoko\\u015bci r\\u00f3wnowarto\\u015bci w z\\u0142otych 100 000 euro. Zapoznaj si\\u0119 z tre\\u015bci\\u0105 ca\\u0142ej informacji\"}, \"interest_info\": \"Oprocentowanie konta oszcz\\u0119dno\\u015bciowego jest zmienne, co wi\\u0105\\u017ce si\\u0119 z ryzykiem spadku lub wzrostu wysoko\\u015bci otrzymanego zysku. Informacja o oprocentowaniu dost\\u0119pna w <a href=\\\"https://static.t-mobilebankowe.pl/uploads//files//TabelaOprocentowania.pdf\\\"> Tabeli Oprocentowania</a>.\", \"available_paycards\": [\"DD\", \"DP\"], \"product_type\": \"4300\", \"presentation_lines\": [\"wysokie oprocentowanie\", \"dost\\u0119pne waluty: EUR, USD, GBP, CHF\"], \"graphic_url\": \"https://static.t-mobilebankowe.pl/uploads/files/KontoOszczednoscioweWalutowe.jpg\"}]}}, \"company_details\": {\"reset\": true, \"is_company\": false}, \"contractors\": {\"reset\": true, \"removed\": [], \"added\": [{\"_item_id\": \"2019061417433813000000000000000000000000000000000000002094617545\", \"transfer_normal_contractor\": {\"account\": \"11114020040000350274893749\", \"name\": \"Maciek Wolak\", \"payment_type\": \"TRANSFER-NORMAL\"}}, {\"_item_id\": \"2019062420220213000000000000000000000000000000000000002115152001\", \"_previous_id\": \"d63e6fcb36d040099614dafa661cfade\", \"transfer_normal_contractor\": {\"account\": \"81102032060000860201081819\", \"name\": \"Pawe\\u0142 Urabn\", \"payment_type\": \"TRANSFER-NORMAL\"}}, {\"_item_id\": \"2019062617094913000000000000000000000000000000000000002120003585\", \"_previous_id\": \"4ac4a0d495cb4e2a843c1c16f60f013c\", \"transfer_normal_contractor\": {\"account\": \"05249010440000420200038287\", \"address\": \"FILTROWA 13/38A, 26-600 RADOM\", \"name\": \"MALINA MI\\u015aTAL\", \"template_id\": \"1742850\", \"payment_type\": \"TRANSFER-NORMAL\"}}], \"changed\": []}, \"money_boxes\": {\"reset\": true, \"summary\": {\"left_to_collect\": \"0\", \"count_of_products\": 0}}, \"client_details\": {\"is_p2p_recipient_by_email\": false, \"mobile_phone\": {\"country\": \"48\", \"number\": \"781***005\"}, \"is_contact_phone_number_and_auth_phone_number_are_the_same\": true, \"cif_hash\": \"21e50321cdbf7efddeec73c100c9dd5dc4009111\", \"private_client\": false, \"personal\": {\"family_name\": \"MI\\u015aTAL\", \"first_name\": \"ALEKSY\", \"citizenship\": \"PL\", \"pesel\": \"czMKW+01NtklOe/jJDfpRyB0f/otGgxo5QXZHLxQtpM=\", \"is_adult\": true, \"sex\": \"MALE\", \"personal_id\": \"wHZplLkYNomflPJj2Hu2cMB3IqQQPs6bv7d1XHU9V+Y=\", \"birth_country\": \"Polska\", \"birth_date\": \"1995-05-21\", \"id\": {\"type\": \"ID-CARD\", \"id\": \"AWS001757\", \"valid_to\": \"2023-06-26\"}}, \"mailing_address\": {\"province\": \"Kfsfqwfef\", \"city\": \"AFWFWF\", \"country\": \"Polska\", \"street\": \"AFASFQQF\", \"postal_code\": \"54-642\", \"house\": \"1/32\"}, \"auth_phone_number\": {\"country\": \"77\", \"number\": \"781***005\"}, \"pep\": \"NO\", \"is_p2p_recipient_by_phone\": true, \"official_address\": {\"province\": \"Afqwfqwf\", \"city\": \"Fqfwwq\", \"country\": \"Pfwqfe\", \"street\": \"Fasfqwf\", \"postal_code\": \"34-321\", \"house\": \"41/31\"}, \"loan_installment_plan_max_count\": 84, \"resident\": \"YES\", \"client_account_source\": \"NEW\", \"email_confirmed\": false, \"residence_address\": {\"province\": \"Masfsaf\", \"city\": \"asfsfa\", \"country\": \"fsafsa\", \"street\": \"fsafswf\", \"postal_code\": \"56-234\", \"house\": \"13/34\"}, \"marketing_agreements\": {\"temporary_marketing_agreement\": false, \"channels_contact\": true, \"marketing_extended\": true, \"voice_contact\": true, \"marketing_objection\": false, \"alior\": true}, \"email\": \"a*****@m*****.***\"}}, \"request_id\": \"vjmG89JBWfnfMWMPVOlIvtmW6\", \"reply\": {\"state\": \"SUCCESS\", \"component_list\": [{\"component_id\": \"1001\", \"component_type\": \"offer_inline\", \"available_in_sm\": false}, {\"component_id\": \"1002\", \"component_type\": \"offer_inline\", \"available_in_sm\": false}, {\"component_id\": \"1003\", \"component_type\": \"offer_inline\", \"available_in_sm\": false}, {\"component_id\": \"1004\", \"component_type\": \"offer_inline\", \"available_in_sm\": false}, {\"component_id\": \"1005\", \"component_type\": \"offer_inline\", \"available_in_sm\": false}, {\"component_id\": \"1006\", \"component_type\": \"offer_inline\", \"available_in_sm\": false}, {\"component_id\": \"1008\", \"component_type\": \"offer_inline\", \"available_in_sm\": false}, {\"component_id\": \"1009\", \"component_type\": \"offer_inline\", \"available_in_sm\": false}, {\"component_id\": \"1010\", \"component_type\": \"offer_inline\", \"available_in_sm\": false}, {\"component_id\": \"1011\", \"component_type\": \"offer_inline\", \"available_in_sm\": false}, {\"component_id\": \"1012\", \"component_type\": \"offer_inline\", \"available_in_sm\": false}, {\"component_id\": \"1014\", \"component_type\": \"offer_inline\", \"available_in_sm\": false}, {\"component_id\": \"121\", \"component_type\": \"offer_block\", \"available_in_sm\": false}, {\"component_id\": \"122\", \"component_type\": \"offer_block\", \"available_in_sm\": false}, {\"component_id\": \"491\", \"component_type\": \"promo_offer\", \"available_in_sm\": false}, {\"component_id\": \"50\", \"component_type\": \"offer_inline_big\", \"available_in_sm\": false}, {\"component_id\": \"56\", \"component_type\": \"offer_inline_big\", \"available_in_sm\": false}, {\"component_id\": \"58\", \"component_type\": \"offer_inline_big\", \"available_in_sm\": false}, {\"component_id\": \"62\", \"component_type\": \"offer_inline_big\", \"available_in_sm\": false}, {\"component_id\": \"68\", \"component_type\": \"offer_inline_big\", \"available_in_sm\": false}, {\"component_id\": \"69\", \"component_type\": \"offer_inline_big\", \"available_in_sm\": false}, {\"component_id\": \"74\", \"component_type\": \"offer_inline_big\", \"available_in_sm\": false}, {\"component_id\": \"75\", \"component_type\": \"offer_inline_big\", \"available_in_sm\": false}, {\"component_id\": \"76\", \"component_type\": \"offer_inline_big\", \"available_in_sm\": false}, {\"component_id\": \"80\", \"component_type\": \"offer_inline_big\", \"available_in_sm\": false}, {\"component_id\": \"82\", \"component_type\": \"offer_inline_big\", \"available_in_sm\": false}, {\"component_id\": \"84\", \"component_type\": \"offer_inline_big\", \"available_in_sm\": false}, {\"component_id\": \"86\", \"component_type\": \"offer_inline_big\", \"available_in_sm\": false}, {\"component_id\": \"88\", \"component_type\": \"offer_inline_big\", \"available_in_sm\": false}, {\"component_id\": \"92\", \"component_type\": \"notification_box\", \"available_in_sm\": false}, {\"component_id\": \"999999999\", \"logout\": true, \"component_type\": \"offer_page\", \"available_in_sm\": false}, {\"component_id\": \"900\", \"component_type\": \"promo_offer\", \"available_in_sm\": false}, {\"component_id\": \"901\", \"component_type\": \"offer_inline_big\", \"available_in_sm\": false}, {\"component_id\": \"902\", \"component_type\": \"offer_inline_big\", \"available_in_sm\": false}], \"flow_id\": \"customer_web_login-Vp3GRLmxB51Q45ZaT2HHAI1xE\"}, \"security\": {\"transmission_key_signature\": \"gPRbF5TNs+ph+PPmTql3TsDPIFK+p44lNXlzKNQoN/FSGj0ch0Y+tLO052FQ9wpkZ/8QlMylLs2QCSn3nwWWXxvOnECHuJekZZuS9Jtm1bMQhw/odSPQLIOsYKuuwYvVUidMNVkkWfjB9umFkJQqJ/E12ytLUk8xwgZGRwb5ln1EiuXdgFV+WVEsKCoz/psp86P/d2Qhacvsg3mhSI5GTFLbu0T/00WodPXPhlSORu1A7iYPPgK0x0qcIaQm2jcSMQAM6Cm3ZlDLAtI3kJGvmIFTELcTzqq5Xj52wLPWwfDL7whgo8SYJWc3JQkAmw/pk/fFjmvnFO/NiV4KnCwyx5RGjtgRmoSQpBPki6k/3wjP8JTqpSyBKLKSTpcS/6Rwc50FHFnFwBd08dPx+1zO3DqolYffYbhQwNe+QoPgfQaOvKW/VD7Rqi5cOoxhYuAAmyJaLYMT7pVPmttGy1yXdRkE8uMiQrE9v69gmBrKNHKtyluXE1wvbsI5NigFjT+EkhVGUQh8gcKnAbof6Fpu1evM8n4SwJTOVJp+lgRjfp6RQ8ke5IuuwNGfLDcKdh3bl4wahSdu2WXdLNwi8mWZYzEc8Qn+mvIFYnOkEZTUu7ZTvzQi4uh5acFJ5kkG4eb8jxa6sqouLrAC640K/CrrdtOga0sAPIxgri3nSEv5da8=\"}}");
    AccountResponseParser testResponseParser = new AccountResponseParser(passwordResponse);
    testAccountsList = (JSONObject) testResponseParser.extractAccountsList().get(0);
  }

  @Test
  public void extractAccountName() {
    assertEquals("Konto Freemium", AccountResponseParser.extractAccountName(testAccountsList));
  }

  @Test
  public void extractAccountBalance() {
    assertEquals("5.81", AccountResponseParser.extractAccountBalance(testAccountsList));
  }

  @Test
  public void extractAccountCurrency() {
    assertEquals("PLN", AccountResponseParser.extractAccountCurrency(testAccountsList));
  }

  @Test
  public void extractAccountNumber() {
    assertEquals("4324324324324324", AccountResponseParser.extractAccountNumber(testAccountsList));
  }

  @Test
  public void extractAccountOpenDate() {
    assertEquals("2096-18-42", AccountResponseParser.extractAccountOpenDate(testAccountsList));
  }

  @Test
  public void extractAccountDescription() {
    assertEquals("Rachunek oszczędnościowo-rozliczeniowy", AccountResponseParser.extractAccountDescription(testAccountsList));
  }

  @Test
  public void extractAccountOwner() {
    assertEquals("ALEKSY MIŚTAL", AccountResponseParser.extractAccountOwner(testAccountsList));
  }

  @Test
  public void extractAccountsList() {
    String testAccountsListString = "{\"account_icon\":\"127\",\"ownership_type_desc\":\"Właściciel\",\"color\":\"#1063AD\",\"ownership_type\":\"OWNER\",\"account_category\":\"ROR\",\"product_code\":\"4200\",\"number\":\"4324324324324324\",\"balance\":{\"ledger\":\"103.96\",\"avail\":\"5.81\"},\"permissions\":{\"can_deposit_open\":true,\"can_sp_transfer\":false,\"source_name_required\":false,\"can_receive_interest\":true,\"can_money_box_open\":true,\"can_register_recommendation_program\":true,\"can_overdraft_limit_order\":true},\"account_name\":\"Konto Freemium\",\"limit_available\":\"0.00\",\"fee_plan\":\"IRR00\",\"statement_frequency\":{},\"account_category_description\":\"Rachunek oszczędnościowo-rozliczeniowy\",\"curr\":\"PLN\",\"open_date\":\"2096-18-42\",\"owner_name\":\"ALEKSY  MIŚTAL\",\"overdraft_limit\":\"0.00\",\"hold_amount\":\"98.15\",\"is_default\":true,\"positive_interest\":{\"rate\":\"0.00\"},\"cashback_availability\":false,\"background\":{\"url\":\"static\\/images\\/backgrounds\\/01.konto_freemium.png\"},\"_item_id\":\"632490\",\"product_code_description\":\"Konto Freemium\",\"limit_used\":\"0\",\"status\":\"ACTIVE\"}";
    assertEquals(testAccountsListString, testAccountsList.toString());

  }
}