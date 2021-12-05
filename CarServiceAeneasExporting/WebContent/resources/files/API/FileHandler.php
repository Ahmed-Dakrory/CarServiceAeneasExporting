<?php
/**
 * Created by PhpStorm.
 * User: Belal
 * Date: 10/5/2017
 * Time: 11:30 AM
 */
class FileHandler
{

    private $con;

    public function __construct()
    {
        require_once dirname(__FILE__) . '/DbConnect.php';

        $db = new DbConnect();
        $this->con = $db->connect();
    }


	
	
	
    public function saveCrashsFile($crashPointsJson,$file, $extension, $carId)
    {
		

        $name = round(microtime(true) * 1000) . '.' . 'jpeg';
        $filedest = UPLOAD_PATH . $name;
        //$moved = move_uploaded_file($file['tmp_name'], $filedest);
		$this->changeImageSize($file['tmp_name'],$filedest);
		
		
		
		
	
	
        $url = $server_ip = gethostbyname(gethostname());
		
		
		
		$lastUpdate = date('Y-m-d H:i:s');
		$stmt = $this->con->prepare("UPDATE car set crashPointsJson = (?), lastUpdate = (?),urlOfCrashImage = (?),dateOfCrashImage = (?) where id  = (?);");
		$stmt->bind_param("ssssi",$crashPointsJson,$lastUpdate,$name,$lastUpdate,$carId);
      
			
        
        
		
		
        if ($stmt->execute())
            return true;
		
        return false;
    }

	
    public function saveSigntureOfDriverDestinationFile($file, $extension, $carId)
    {
		

        $name = round(microtime(true) * 1000) . '.' . 'jpeg';
        $filedest = UPLOAD_PATH . $name;
        //$moved = move_uploaded_file($file['tmp_name'], $filedest);
		$this->changeImageSize($file['tmp_name'],$filedest);
		
		
		
		
	
	
        $url = $server_ip = gethostbyname(gethostname());
		
		$lastUpdate = date('Y-m-d H:i:s');
		$stmt = $this->con->prepare("UPDATE car set lastUpdate = (?),urlOfDriverSigntureDestination = (?),dateOfDriverSigntureDestination = (?) where id  = (?);");
		$stmt->bind_param("sssi",$lastUpdate,$name,$lastUpdate,$carId);
      
			
        
        
		
		
        if ($stmt->execute())
            return true;
		
        return false;
    }

	
	
	
    public function saveSigntureOfDriverFile($file, $extension, $carId)
    {
		

        $name = round(microtime(true) * 1000) . '.' . 'jpeg';
        $filedest = UPLOAD_PATH . $name;
        //$moved = move_uploaded_file($file['tmp_name'], $filedest);
		$this->changeImageSize($file['tmp_name'],$filedest);
		
		
		
		
	
	
        $url = $server_ip = gethostbyname(gethostname());
		
		$lastUpdate = date('Y-m-d H:i:s');
		$stmt = $this->con->prepare("UPDATE car set lastUpdate = (?),urlOfDriverSignture = (?),dateOfDriverSignture = (?) where id  = (?);");
		$stmt->bind_param("sssi",$lastUpdate,$name,$lastUpdate,$carId);
      
			
        
        
		
		
        if ($stmt->execute())
            return true;
		
        return false;
    }

	
	
    public function saveFile($file, $extension, $carId,$type)
    {
		
		if($extension == "pdf"){
			 $name = round(microtime(true) * 1000) . '.' . 'pdf';
        $filedest = UPLOAD_PATH_PDF . $name;
        move_uploaded_file($file, $filedest);
		//$this->changeImageSize($file,$filedest);
		
		
        $url = $server_ip = gethostbyname(gethostname());
        $stmt = $this->con->prepare("INSERT INTO carimage (carId, url, type) VALUES (?, ?, ?)");
		
        $stmt->bind_param("isi", $carId, $name,$type);
		
        if ($stmt->execute())
            return true;
		
		
		}else{
        $name = round(microtime(true) * 1000) . '.' . 'jpeg';
        $filedest = UPLOAD_PATH . $name;
        //move_uploaded_file($file, $filedest);
		$this->changeImageSize($file,$filedest);
		
		
        $url = $server_ip = gethostbyname(gethostname());
        $stmt = $this->con->prepare("INSERT INTO carimage (carId, url, type) VALUES (?, ?, ?)");
		
        $stmt->bind_param("isi", $carId, $name,$type);
		
        if ($stmt->execute())
            return true;
		
		}
        return false;
    }

	
	public function changeImageSize($f1,$upload_path) {
		
		
    $image_resource_id = imagecreatefromjpeg($f1); 

	$source_properties = getimagesize($f1);
	
	$target_width =850;
	$target_height =640;
	$target_layer=imagecreatetruecolor($target_width,$target_height);
	imagecopyresampled($target_layer,$image_resource_id,0,0,0,0,$target_width,$target_height,$source_properties[0],$source_properties[1]);

    imagejpeg($target_layer,$upload_path );
	
	
	$exif = exif_read_data($f1);
	/*
	$file = fopen("newfile.txt","w");
	
	fwrite($file,"Ahmed\n");
	
	fwrite($file,$exif['Orientation']);
    
	fclose($file);
*/

	$ort = $exif['Orientation'];

	$orientation = $ort;
	
	// Fix Orientation
    switch($orientation) {
        case 3:
            $target_layer = imagerotate($target_layer, 180, 0);
            break;
        case 6:
            $target_layer = imagerotate($target_layer, -90, 0);
            break;
        case 8:
            $target_layer = imagerotate($target_layer, 90, 0);
            break;
    }
	
	 // Output
    imagejpeg($target_layer,$upload_path, 90);
	
	}

	
	
    public function getAllFiles()
    {
        $stmt = $this->con->prepare("SELECT id, description, image FROM images ORDER BY id DESC");
        $stmt->execute();
        $stmt->bind_result($id, $desc, $url);

        $images = array();

        while ($stmt->fetch()) {

            $temp = array();
            $absurl = 'http://143.244.151.25:8083/' . UPLOAD_PATH . $url;
            $temp['id'] = $id;
            $temp['desc'] = $desc;
            $temp['image'] = $absurl;
            array_push($images, $temp);
        }

        return $images;
    }
	
	 public function getUser($user, $hashPass)
    {
		
		
        $stmt = $this->con->prepare("SELECT id,userName,firstName,lastName,email,mainUserId,role FROM user where userName = ? and password = ? and active = 1 ORDER BY id DESC");
		
        $stmt->bind_param("ss", $user, $hashPass);
        $stmt->execute();
		
        $stmt->bind_result($id,$userName,$firstName,$lastName,$email,$mainUserId,$role);

        $temp = array();
			$temp['id'] = 0;
			$temp['userName'] = "";
			$temp['firstName'] = "";
			$temp['lastName'] = "";
			$temp['email'] = "";
			$temp['mainUserId'] = 0;
			$temp['role'] = 0;
        while ($stmt->fetch()) {

            $temp['id'] = $id;
			$temp['userName'] = $userName;
			$temp['firstName'] = $firstName;
			$temp['lastName'] = $lastName;
			$temp['email'] = $email;
			$temp['mainUserId'] = $mainUserId;
			//$temp['image'] = base64_encode($image);
			$temp['role'] = $role;
        }

			$data = $this->getReleatedData($temp['id'],$temp['role']);
			$temp['shipperId'] = $data['shipperId'];
			$temp['vendorId'] = $data['vendorId'];
			$temp['customerId'] = $data['customerId'];
			$temp['consigneeId'] = $data['consigneeId'];
			$temp['mainTwoId'] = $data['mainTwoId'];
			$temp['allowAccess'] = $data['allowAccess'];
		
        return $temp;
    }
	
	 public function getImageFromUserId($userId)
    {
		
		
        $stmt = $this->con->prepare("SELECT image FROM user where id = ?");
		
        $stmt->bind_param("s", $userId);
        $stmt->execute();
		
        $stmt->bind_result($image);

        $temp = array();
			
        while ($stmt->fetch()) {

            $temp['id'] = $userId;
			if($image !=null){
				$temp['image'] = base64_encode($image);
			}else{
				$temp['image'] = "";
			}
			
        }

		
		
        return $temp;
    }
	
	 public function getReleatedData($userId,$role)
    {
		
		if($role == 0){
			//ROLE_MAIN 
			
			$temp = array();


				$temp['shipperId'] = 0;
				$temp['vendorId'] = 0;
				$temp['customerId'] = 0;
				$temp['consigneeId'] = 0;
				$temp['mainTwoId'] = 0;
				$temp['allowAccess'] = 1;
			
			
			return $temp;
			
		}else if($role == 1){
			//ROLE_SHIPPER
			$stmt = $this->con->prepare("SELECT id,allowAccess,parentId FROM shipper where userId = ? ");
		
			$stmt->bind_param("s", $userId);
			$stmt->execute();
			
			$stmt->bind_result($id,$allowAccess,$parentId);

			$temp = array();

			while ($stmt->fetch()) {

				$temp['shipperId'] = $id;
				$temp['vendorId'] = 0;
				$temp['customerId'] = 0;
				$temp['consigneeId'] = 0;
				$temp['mainTwoId'] = 0;
				$temp['allowAccess'] = $allowAccess;
			}

			
			
			return $temp;
			
		}else if($role == 2){
			//ROLE_VENDOR
			

			
			$stmt = $this->con->prepare("SELECT id,allowAccess,parentId FROM vendor where userId = ? ");
		
			$stmt->bind_param("s", $userId);
			$stmt->execute();
			
			$stmt->bind_result($id,$allowAccess,$parentId);

			$temp = array();

			while ($stmt->fetch()) {

				$temp['shipperId'] = $parentId;
				$temp['vendorId'] = $id;
				$temp['customerId'] = 0;
				$temp['consigneeId'] = 0;
				$temp['mainTwoId'] = 0;
				$temp['allowAccess'] = $allowAccess;
			}
			
			
			
			return $temp;
			
		}else if($role == 3){
			//ROLE_CUSTOMER
			$stmt = $this->con->prepare("SELECT id,allowAccess,parentId FROM customer where userId = ? ");
		
			$stmt->bind_param("s", $userId);
			$stmt->execute();
			
			$stmt->bind_result($id,$allowAccess,$parentId);

			$temp = array();

			while ($stmt->fetch()) {

				$temp['shipperId'] = 0;
				$temp['vendorId'] = $parentId;
				$temp['customerId'] = $id;
				$temp['consigneeId'] = 0;
				$temp['mainTwoId'] = 0;
				$temp['allowAccess'] = $allowAccess;
			}
			
			$stmt = $this->con->prepare("SELECT id,allowAccess,parentId FROM vendor where id = ? ");
		
			$stmt->bind_param("s", $temp['vendorId']);
			$stmt->execute();
			
			$stmt->bind_result($id,$allowAccess,$parentId);

			$temp = array();

			while ($stmt->fetch()) {

				$temp['shipperId'] = $parentId;
			}
			
			

			
			
			return $temp;
			
		}else if($role == 4){
			//ROLE_CONGSIGNEE
			
			$stmt = $this->con->prepare("SELECT id,parentId FROM consignee where userId = ? ");
		
			$stmt->bind_param("s", $userId);
			$stmt->execute();
			
			$stmt->bind_result($id,$parentId);

			$temp = array();

			while ($stmt->fetch()) {

				$temp['shipperId'] = $parentId;
				$temp['vendorId'] = 0;
				$temp['customerId'] = 0;
				$temp['consigneeId'] = $id;
				$temp['mainTwoId'] = 0;
				$temp['allowAccess'] = 1;
			}
			
			return $temp;
		}else if($role == 5){
			//ROLE_MAIN2
				
			$stmt = $this->con->prepare("SELECT id,allowAccess,parentId FROM mainTwo where userId = ? ");
		
			$stmt->bind_param("s", $userId);
			$stmt->execute();
			
			$stmt->bind_result($id,$allowAccess,$parentId);

			$temp = array();

			while ($stmt->fetch()) {

				$temp['shipperId'] = 0;
				$temp['vendorId'] = 0;
				$temp['customerId'] = 0;
				$temp['consigneeId'] = 0;
				$temp['mainTwoId'] = $id;
				$temp['allowAccess'] = $allowAccess;
			}
			
			
			
			return $temp;
			
		}
       
    }
	
	
	
	 public function getCarImages($id)
    {
		
        $data = array();
		$stmt = $this->con->prepare("SELECT url FROM carimage where carId=? and type = 0 and deleted = 0");
		
        $stmt->bind_param("s", $id);
        $stmt->execute();
		
        $stmt->bind_result($url);

        $AllImages = array();

        while ($stmt->fetch()) {
            $images = array();
            $images['url'] = $url;
            $images['type'] = 1;
            array_push($AllImages, $images);
        }
		return $AllImages;
	}
	
	public function getCarDoc($id)
    {
		
        $data = array();
		
		$stmt = $this->con->prepare("SELECT url FROM carimage where carId=? and type = 1 and deleted = 0");
		
        $stmt->bind_param("s", $id);
        $stmt->execute();
		
        $stmt->bind_result($url);

        $AllDocs = array();

        while ($stmt->fetch()) {
            $docs = array();
            $docs['url'] = $url;
            $docs['type'] = 1;
            array_push($AllDocs, $docs);
        }
		return $AllDocs;
	}
	
	
	public function getCarPdf($id)
    {
		
        $data = array();
		
		$stmt = $this->con->prepare("SELECT url FROM carimage where carId=? and type = 2 and deleted = 0");
		
        $stmt->bind_param("s", $id);
        $stmt->execute();
		
        $stmt->bind_result($url);

        $AllDocs = array();

        while ($stmt->fetch()) {
            $docs = array();
            $docs['url'] = $url;
            $docs['type'] = 1;
            array_push($AllDocs, $docs);
        }
		return $AllDocs;
	}
	
	public function getStringAsReq($st){
		if($st == null){
			return "";
		}
		return $st;
	}
	
	public function getIdData($id){
		
		return $id;
	}
	
	
	public function getShippersAllData($id)
    {
		$dataShippers = array();
        $stmt = $this->con->prepare("SELECT user.company, user.firstName,user.lastName,shipper.id FROM carsystem.shipper left join user on user.id = shipper.userId  where shipper.parentId=? and shipper.deleted = 0");
		
        $stmt->bind_param("s", $id);
        $stmt->execute();
		
        $stmt->bind_result($company, $shippersName_first,$shippersName_second,$shippersId);

        while ($stmt->fetch()) {
            $temp['id'] = $shippersId;
			$temp['name'] = $company;
			array_push($dataShippers, $temp);
		}
		
        return $dataShippers;
	}
	public function getCarData($id)
    {
		
		
		
		
		
		
        $data = array();
        $stmt = $this->con->prepare("SELECT  car.titleExist,car.keyExist,car.companyTransName,car.driverName,car.driverPhone,car.dateOfDriverSigntureDestination,car.urlOfDriverSigntureDestination,car.CarType,car.crashPointsJson,car.dateOfCrashImage,car.urlOfCrashImage,car.dateOfDriverSignture,car.urlOfDriverSignture,car.mainId,car.mainTwoId,car.shipperId,car.vendorId,car.customerId,car.consigneeId, user.firstName,user.lastName,tmainTwo.firstName,tmainTwo.lastName,tshipper.firstName,tshipper.lastName,tvendor.firstName,tvendor.lastName,tconsignee.firstName,tconsignee.lastName,tcustomer.firstName,tcustomer.lastName,make,model,year,bodyStyle,engineType,engineLiters,car.assemlyCountry,car.color,car.seacost,car.landcost,car.state,car.releaseOption,car.stateOut,car.releaseDate,car.uuid,car.description,car.containerLink,car.eta,car.etd FROM carsystem.car left join user on user.id = car.mainId left join customer on customer.id = car.customerId left join shipper on shipper.id = car.shipperId left join vendor on vendor.id = car.vendorId left join consignee on consignee.id = car.consigneeId left join user as tvendor on tvendor.id = vendor.userId left join user as tshipper on tshipper.id = shipper.userId left join user as tcustomer on tcustomer.id = customer.userId left join user as tconsignee on tconsignee.id = consignee.userId left join user as tmainTwo on tmainTwo.id = car.mainTwoId  where car.id=? and car.deleted = 0");
		
        $stmt->bind_param("s", $id);
        $stmt->execute();
		
        $stmt->bind_result($titleExist,$keyExist,$companyTransName,$driverName,$driverPhone,$dateOfDriverSigntureDestination,$urlOfDriverSigntureDestination,$CarType,$crashPointsJson,$dateOfCrashImage,$urlOfCrashImage,$dateOfDriverSignture,$urlOfDriverSignture,$mainId,$mainTwoId,$shipperId,$vendorId,$customerId,$consigneeId,$userfirstName,$userlastName,$mainTwofirstName,$mainTwolastName,$shipperfirstName,$shipperlastName,$vendorfirstName,$vendorlastName,$consigneefirstName,$consigneelastName,$customerfirstName,$customerlastName,$make,$model,$year,$bodyStyle,$engineType,$engineLiters,$assemlyCountry,$color,$seacost,$landcost,$state,$releaseOption,$stateOut,$releaseDate,$uuid,$description,$containerLink,$eta,$etd);


        while ($stmt->fetch()) {
            $temp['id'] = $id;
			$temp['dateOfDriverSigntureDestination'] = $dateOfDriverSigntureDestination;
			$temp['urlOfDriverSigntureDestination'] = $urlOfDriverSigntureDestination;
			$temp['CarType']=$CarType;
			
			if($titleExist==0){
				
			$temp['titleExist']=false;
			}else{
				
			$temp['titleExist']=true;
			}
			
			
			if($keyExist==0){
				
			$temp['keyExist']=false;
			}else{
				
			$temp['keyExist']=true;
			}
			
			
			$temp['companyTransName'] = $companyTransName;
			$temp['driverName'] = $driverName;
			$temp['driverPhone']=$driverPhone;
			$temp['crashPointsJson'] = $crashPointsJson;
			$temp['dateOfCrashImage'] = $dateOfCrashImage;
			$temp['urlOfCrashImage'] = $urlOfCrashImage;
			$temp['dateOfDriverSignture'] = $dateOfDriverSignture;
			$temp['urlOfDriverSignture'] = $urlOfDriverSignture;
			$temp['mainId'] = $this->getIdData($mainId);
            $temp['mainTwoId'] = $this->getIdData($mainTwoId);
            $temp['shipperId'] = $this->getIdData($shipperId);
            $temp['vendorId'] = $this->getIdData($vendorId);
            $temp['customerId'] = $this->getIdData($customerId);
            $temp['consigneeId'] = $this->getIdData($consigneeId);
			$temp['userfirstName'] = $this->getStringAsReq($userfirstName);
			$temp['userlastName'] = $this->getStringAsReq($userlastName);
			$temp['mainTwofirstName'] = $this->getStringAsReq($mainTwofirstName);
			$temp['mainTwolastName'] = $this->getStringAsReq($mainTwolastName);
			$temp['shipperfirstName'] = $this->getStringAsReq($shipperfirstName);
			$temp['shipperlastName'] = $this->getStringAsReq($shipperlastName);
			$temp['vendorfirstName'] = $this->getStringAsReq($vendorfirstName);
			$temp['vendorlastName'] = $this->getStringAsReq($vendorlastName);
			$temp['consigneefirstName'] = $this->getStringAsReq($consigneefirstName);
			$temp['consigneelastName'] = $this->getStringAsReq($consigneelastName);
			$temp['customerfirstName'] = $this->getStringAsReq($customerfirstName);
			$temp['customerlastName'] = $this->getStringAsReq($customerlastName);
			$temp['make'] = $make;
			$temp['model'] = $model;
			$temp['year'] = $year;
			$temp['bodyStyle'] = $bodyStyle;
			$temp['engineType'] = $engineType;
			$temp['engineLiters'] = $engineLiters;
			$temp['assemlyCountry'] = $assemlyCountry;
			$temp['color'] = $color;
			$temp['seacost'] = $seacost;
			$temp['landcost'] = $landcost;
			$temp['state'] = $state;
			$temp['releaseOption'] = $releaseOption;
			$temp['stateOut'] = $stateOut;
			$temp['releaseDate'] = $releaseDate;
			$temp['uuid'] = $uuid;
			$temp['description'] = $description;
			$temp['containerLink'] = $containerLink;
			$temp['eta'] = $eta;
			$temp['etd'] = $etd;
        }

		
        return $temp;
    }
	
	
	public function insertNewCar($titleExist,$keyExist,$companyTransName,$driverName,$driverPhone,$CarType,$idOfCar,$mainId,$mainTwoId,$shipperId,$vendorId,$customerId,$consigneeId,$make,$model,$year,$bodyStyle,$engineType,$engineLiters,$assemlyCountry,$color,$seacost,$landcost,$state,$releaseOption,$stateOut,$releaseDate,$uuid,$description,$containerLink,$eta,$etd)
    {
		if($releaseDate == '')
			$releaseDate = null;
		if($eta == '')
			$eta = null;
		if($etd == '')
			$etd = null;
		
		if($titleExist){
			$titleExist = 1;
		}else{
			$titleExist = 0;
		}
		
		if($keyExist){
			$keyExist = 1;
		}else{
			$keyExist = 0;
		}
		/*
		echo $make."\n";
		echo $model."\n";
		echo $year."\n";
		echo $bodyStyle."\n";
		echo $engineType."\n";
		echo $engineLiters."\n";
		echo $assemlyCountry."\n";
		echo $color."\n";
		echo $seacost."\n";
		echo $landcost."\n";
		echo $state."\n";
		echo $releaseOption."\n";
		echo $releaseDate."\n";
		echo $uuid."\n";
		echo $description."\n";
		echo $containerLink."\n";
		echo $eta."\n";
		echo $etd."\n";
		$myfile = fopen("newfile.txt", "w") or die("Unable to open file!");
		fwrite($myfile, $bodyStyle);
		fclose($myfile);
		
		*/
		$lastUpdate = date('Y-m-d H:i:s');
		
		
		$stmt = $this->con->prepare("SELECT car.id FROM carsystem.car where car.uuid=(?) and car.deleted = 0");
		
        $stmt->bind_param("s", $uuid);
        $stmt->execute();
		
        $stmt->bind_result($id);


        while ($stmt->fetch()) {
            $dataIdCheck = $this->getIdData($id);
		}
		
		if($dataIdCheck  > 0){
			$stmt = $this->con->prepare("UPDATE car set titleExist=(?), keyExist=(?), companyTransName = (?),  driverName = (?),  driverPhone = (?),  CarType = (?), mainId = (?), mainTwoId = (?),shipperId = (?),vendorId = (?),customerId = (?),consigneeId = (?),make = (?),model = (?),year = (?),bodyStyle = (?),engineType = (?),engineLiters = (?),assemlyCountry = (?),color = (?),seacost = (?),landcost = (?),state = (?),releaseOption = (?), stateOut = (?),releaseDate = (?),uuid = (?),description = (?),containerLink = (?),eta = (?),etd = (?),lastUpdate = (?),mobileOrComp = 1 where id  = (?);");
			$stmt->bind_param("iissssiiiiiissssssssssiiisssssssi",$titleExist,$keyExist,$companyTransName,$driverName,$driverPhone,$CarType,$mainId,$mainTwoId,$shipperId,$vendorId,$customerId,$consigneeId,$make,$model,$year,$bodyStyle,$engineType,$engineLiters,$assemlyCountry,$color,$seacost,$landcost,$state,$releaseOption,$stateOut,$releaseDate,$uuid,$description,$containerLink,$eta,$etd,$lastUpdate,$dataIdCheck);
      
			
		}else{
			$stmt = $this->con->prepare("INSERT INTO car (titleExist,keyExist,cargoRecieved,companyTransName,driverName,driverPhone,CarType,mainId,mainTwoId,shipperId,vendorId,customerId,consigneeId,make,model,year,bodyStyle,engineType,engineLiters,assemlyCountry,color,seacost,landcost,state,releaseOption,stateOut,releaseDate,uuid,description,containerLink,eta,etd,lastUpdate,mobileOrComp) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,1);");
			$stmt->bind_param("iisssssiiiiiissssssssssiiisssssss",$titleExist,$keyExist,$lastUpdate,$companyTransName,$driverName,$driverPhone,$CarType,$mainId,$mainTwoId,$shipperId,$vendorId,$customerId,$consigneeId,$make,$model,$year,$bodyStyle,$engineType,$engineLiters,$assemlyCountry,$color,$seacost,$landcost,$state,$releaseOption,$stateOut,$releaseDate,$uuid,$description,$containerLink,$eta,$etd,$lastUpdate);
      
		}
        
        
		
		 $stmt->execute();
		
        $data = array();
        $stmt = $this->con->prepare("SELECT car.titleExist,car.keyExist,car.companyTransName,car.driverName,car.driverPhone,car.dateOfDriverSigntureDestination,car.urlOfDriverSigntureDestination,car.CarType,car.crashPointsJson,car.dateOfCrashImage,car.urlOfCrashImage,car.dateOfDriverSignture,car.urlOfDriverSignture,car.id,car.mainId,car.mainTwoId,car.shipperId,car.vendorId,car.customerId,car.consigneeId, user.firstName,user.lastName,tmainTwo.firstName,tmainTwo.lastName,tshipper.firstName,tshipper.lastName,tvendor.firstName,tvendor.lastName,tconsignee.firstName,tconsignee.lastName,tcustomer.firstName,tcustomer.lastName,make,model,year,bodyStyle,engineType,engineLiters,car.assemlyCountry,car.color,car.seacost,car.landcost,car.state,car.releaseOption,car.stateOut,car.releaseDate,car.uuid,car.description,car.containerLink,car.eta,car.etd FROM carsystem.car left join user on user.id = car.mainId left join customer on customer.id = car.customerId left join shipper on shipper.id = car.shipperId left join vendor on vendor.id = car.vendorId left join consignee on consignee.id = car.consigneeId left join user as tvendor on tvendor.id = vendor.userId left join user as tshipper on tshipper.id = shipper.userId left join user as tcustomer on tcustomer.id = customer.userId left join user as tconsignee on tconsignee.id = consignee.userId left join user as tmainTwo on tmainTwo.id = car.mainTwoId  where car.uuid=(?) and car.deleted = 0");
		
        $stmt->bind_param("s", $uuid);
        $stmt->execute();
		
        $stmt->bind_result($titleExist,$keyExist,$companyTransName,$driverName,$driverPhone,$dateOfDriverSigntureDestination,$urlOfDriverSigntureDestination,$CarType,$crashPointsJson,$dateOfCrashImage,$urlOfCrashImage,$dateOfDriverSignture,$urlOfDriverSignture,$id,$mainId,$mainTwoId,$shipperId,$vendorId,$customerId,$consigneeId,$userfirstName,$userlastName,$mainTwofirstName,$mainTwolastName,$shipperfirstName,$shipperlastName,$vendorfirstName,$vendorlastName,$consigneefirstName,$consigneelastName,$customerfirstName,$customerlastName,$make,$model,$year,$bodyStyle,$engineType,$engineLiters,$assemlyCountry,$color,$seacost,$landcost,$state,$releaseOption,$stateOut,$releaseDate,$uuid,$description,$containerLink,$eta,$etd);


        while ($stmt->fetch()) {
            $temp['id'] = $this->getIdData($id);
			$temp['CarType']=$CarType;
			if($keyExist==0){
				
			$temp['keyExist']=false;
			}else{
				
			$temp['keyExist']=true;
			}
			
			if($titleExist==0){
				
			$temp['titleExist']=false;
			}else{
				
			$temp['titleExist']=true;
			}
			
			$temp['dateOfDriverSigntureDestination'] = $dateOfDriverSigntureDestination;
			$temp['urlOfDriverSigntureDestination'] = $urlOfDriverSigntureDestination;
			$temp['crashPointsJson'] = $crashPointsJson;
			$temp['companyTransName'] = $companyTransName;
			$temp['driverName'] = $driverName;
			$temp['driverPhone'] = $driverPhone;
			$temp['dateOfCrashImage'] = $dateOfCrashImage;
			$temp['urlOfCrashImage'] = $urlOfCrashImage;
			$temp['dateOfDriverSignture'] = $dateOfDriverSignture;
			$temp['urlOfDriverSignture'] = $urlOfDriverSignture;
            $temp['mainId'] = $this->getIdData($mainId);
            $temp['mainTwoId'] = $this->getIdData($mainTwoId);
            $temp['shipperId'] = $this->getIdData($shipperId);
            $temp['vendorId'] = $this->getIdData($vendorId);
            $temp['customerId'] = $this->getIdData($customerId);
            $temp['consigneeId'] = $this->getIdData($consigneeId);
			$temp['userfirstName'] = $this->getStringAsReq($userfirstName);
			$temp['userlastName'] = $this->getStringAsReq($userlastName);
			$temp['mainTwofirstName'] = $this->getStringAsReq($mainTwofirstName);
			$temp['mainTwolastName'] = $this->getStringAsReq($mainTwolastName);
			$temp['shipperfirstName'] = $this->getStringAsReq($shipperfirstName);
			$temp['shipperlastName'] = $this->getStringAsReq($shipperlastName);
			$temp['vendorfirstName'] = $this->getStringAsReq($vendorfirstName);
			$temp['vendorlastName'] = $this->getStringAsReq($vendorlastName);
			$temp['consigneefirstName'] = $this->getStringAsReq($consigneefirstName);
			$temp['consigneelastName'] = $this->getStringAsReq($consigneelastName);
			$temp['customerfirstName'] = $this->getStringAsReq($customerfirstName);
			$temp['customerlastName'] = $this->getStringAsReq($customerlastName);
			$temp['make'] = $make;
			$temp['model'] = $model;
			$temp['year'] = $year;
			$temp['bodyStyle'] = $bodyStyle;
			$temp['engineType'] = $engineType;
			$temp['engineLiters'] = $engineLiters;
			$temp['assemlyCountry'] = $assemlyCountry;
			$temp['color'] = $color;
			$temp['seacost'] = $seacost;
			$temp['landcost'] = $landcost;
			$temp['state'] = $state;
			$temp['releaseOption'] = $releaseOption;
			$temp['stateOut'] = $stateOut;
			$temp['releaseDate'] = $releaseDate;
			$temp['uuid'] = $uuid;
			$temp['description'] = $description;
			$temp['containerLink'] = $containerLink;
			$temp['eta'] = $eta;
			$temp['etd'] = $etd;
        }

		
        return $temp;
    }
	
	 public function getAllCarsForMainAccount($mainId,$page,$itemsNumber,$type)
    {
		if($type == 0){
			$stmt = $this->con->prepare("SELECT  car.state,car.lastUpdate,user.firstName,user.lastName,car.id,car.shipperId,car.uuid,car.make,car.model,car.year,car.releaseOption,carimage.url  FROM car  LEFT JOIN shipper on car.shipperId = shipper.id LEFT JOIN user on shipper.userId = user.id LEFT JOIN carimage  on carimage.carId=car.id and carimage.type=0 where car.mainId=? and car.deleted = 0   group by  car.id order by car.lastUpdate DESC LIMIT ?,?;");
		
		}elseif($type == 1){
            //WareHouse
			$stmt = $this->con->prepare("SELECT  car.state,car.lastUpdate,user.firstName,user.lastName,car.id,car.shipperId,car.uuid,car.make,car.model,car.year,car.releaseOption,carimage.url  FROM car  LEFT JOIN shipper on car.shipperId = shipper.id LEFT JOIN user on shipper.userId = user.id LEFT JOIN carimage  on carimage.carId=car.id and carimage.type=0 where car.mainId=? and (car.state=0 or car.state=1 or car.state=2 or car.state=3) and car.deleted = 0   group by  car.id order by car.lastUpdate DESC LIMIT ?,?;");
		
        }elseif($type == 2){
            //Dry Cargo
			$stmt = $this->con->prepare("SELECT  car.state,car.lastUpdate,user.firstName,user.lastName,car.id,car.shipperId,car.uuid,car.make,car.model,car.year,car.releaseOption,carimage.url  FROM car  LEFT JOIN shipper on car.shipperId = shipper.id LEFT JOIN user on shipper.userId = user.id LEFT JOIN carimage  on carimage.carId=car.id and carimage.type=0 where car.mainId=? and (car.state=4 or car.state=5) and car.deleted = 0   group by  car.id order by car.lastUpdate DESC LIMIT ?,?;");
		
        }elseif($type == 3){
            //Fright in Transit
			$stmt = $this->con->prepare("SELECT  car.state,car.lastUpdate,user.firstName,user.lastName,car.id,car.shipperId,car.uuid,car.make,car.model,car.year,car.releaseOption,carimage.url  FROM car  LEFT JOIN shipper on car.shipperId = shipper.id LEFT JOIN user on shipper.userId = user.id LEFT JOIN carimage  on carimage.carId=car.id and carimage.type=0 where car.mainId=? and (car.state=6 or car.state=7) and car.deleted = 0   group by  car.id order by car.lastUpdate DESC LIMIT ?,?;");
		
        }elseif($type == 4){
            //Sent For Payment
			$stmt = $this->con->prepare("SELECT  car.state,car.lastUpdate,user.firstName,user.lastName,car.id,car.shipperId,car.uuid,car.make,car.model,car.year,car.releaseOption,carimage.url  FROM car  LEFT JOIN shipper on car.shipperId = shipper.id LEFT JOIN user on shipper.userId = user.id LEFT JOIN carimage  on carimage.carId=car.id and carimage.type=0 where car.mainId=? and (car.state=8) and car.deleted = 0   group by  car.id order by car.lastUpdate DESC LIMIT ?,?;");
		
        }
        
        $stmt->bind_param("sss", $mainId, $page, $itemsNumber);
        $stmt->execute();
		
        $stmt->bind_result($state,$lastUpdateCar,$firstName,$lastName,$id,$shipperId,$uuid,$make,$model,$year,$releaseOption,$url);

        $data = array();

        while ($stmt->fetch()) {

            $temp = array();
            $temp['id'] = $id;
			$temp['state'] = $state;
			$temp['lastUpdateCar'] = $lastUpdateCar;
			$temp['shipper_firstName'] = $this->getStringAsReq($firstName);
			$temp['shipper_lastName'] = $this->getStringAsReq($lastName);
			$temp['shipperId'] = $shipperId;
			$temp['uuid'] = $uuid;
			$temp['make'] = $make;
			$temp['model'] = $model;
			$temp['year'] = $year;
			$temp['releaseOption'] = $releaseOption;
			$temp['url'] = $url;
            array_push($data, $temp);
        }

        return $data;
    }

	
	
	 public function getAllCarsForMainTwoAccount($mainTwoId,$page,$itemsNumber,$type)
    {
		if($type == 0){
			$stmt = $this->con->prepare("SELECT  car.state,car.lastUpdate,user.firstName,user.lastName,car.id,car.shipperId,car.uuid,car.make,car.model,car.year,car.releaseOption,carimage.url  FROM car  LEFT JOIN shipper on car.shipperId = shipper.id LEFT JOIN user on shipper.userId = user.id LEFT JOIN carimage  on carimage.carId=car.id and carimage.type=0 where car.mainTwoId=? and car.deleted = 0   group by  car.id order by car.lastUpdate DESC LIMIT ?,?;");
		
		}elseif($type == 1){
            //WareHouse
			$stmt = $this->con->prepare("SELECT  car.state,car.lastUpdate,user.firstName,user.lastName,car.id,car.shipperId,car.uuid,car.make,car.model,car.year,car.releaseOption,carimage.url  FROM car  LEFT JOIN shipper on car.shipperId = shipper.id LEFT JOIN user on shipper.userId = user.id LEFT JOIN carimage  on carimage.carId=car.id and carimage.type=0 where car.mainTwoId=? and (car.state=0 or car.state=1 or car.state=2 or car.state=3) and car.deleted = 0   group by  car.id order by car.lastUpdate DESC LIMIT ?,?;");
		
        }elseif($type == 2){
            //Dry Cargo
			$stmt = $this->con->prepare("SELECT  car.state,car.lastUpdate,user.firstName,user.lastName,car.id,car.shipperId,car.uuid,car.make,car.model,car.year,car.releaseOption,carimage.url  FROM car  LEFT JOIN shipper on car.shipperId = shipper.id LEFT JOIN user on shipper.userId = user.id LEFT JOIN carimage  on carimage.carId=car.id and carimage.type=0 where car.mainTwoId=? and (car.state=4 or car.state=5) and car.deleted = 0   group by  car.id order by car.lastUpdate DESC LIMIT ?,?;");
		
        }elseif($type == 3){
            //Fright in Transit
			$stmt = $this->con->prepare("SELECT  car.state,car.lastUpdate,user.firstName,user.lastName,car.id,car.shipperId,car.uuid,car.make,car.model,car.year,car.releaseOption,carimage.url  FROM car  LEFT JOIN shipper on car.shipperId = shipper.id LEFT JOIN user on shipper.userId = user.id LEFT JOIN carimage  on carimage.carId=car.id and carimage.type=0 where car.mainTwoId=? and (car.state=6 or car.state=7) and car.deleted = 0   group by  car.id order by car.lastUpdate DESC LIMIT ?,?;");
		
        }elseif($type == 4){
            //Sent For Payment
			$stmt = $this->con->prepare("SELECT  car.state,car.lastUpdate,user.firstName,user.lastName,car.id,car.shipperId,car.uuid,car.make,car.model,car.year,car.releaseOption,carimage.url  FROM car  LEFT JOIN shipper on car.shipperId = shipper.id LEFT JOIN user on shipper.userId = user.id LEFT JOIN carimage  on carimage.carId=car.id and carimage.type=0 where car.mainTwoId=? and (car.state=8) and car.deleted = 0   group by  car.id order by car.lastUpdate DESC LIMIT ?,?;");
		
        }
        
        $stmt->bind_param("sss", $mainTwoId, $page, $itemsNumber);
        $stmt->execute();
		
        $stmt->bind_result($state,$lastUpdateCar,$firstName,$lastName,$id,$shipperId,$uuid,$make,$model,$year,$releaseOption,$url);

        $data = array();

        while ($stmt->fetch()) {

            $temp = array();
            $temp['id'] = $id;
			$temp['state'] = $state;
			$temp['lastUpdateCar'] = $lastUpdateCar;
			$temp['shipper_firstName'] = $this->getStringAsReq($firstName);
			$temp['shipper_lastName'] = $this->getStringAsReq($lastName);
			$temp['shipperId'] = $shipperId;
			$temp['uuid'] = $uuid;
			$temp['make'] = $make;
			$temp['model'] = $model;
			$temp['year'] = $year;
			$temp['releaseOption'] = $releaseOption;
			$temp['url'] = $url;
            array_push($data, $temp);
        }

        return $data;
    }

	
	
	 public function getAllCarsForShipperAccount($shipperId,$page,$itemsNumber,$type)
    {
		if($type == 0){
			$stmt = $this->con->prepare("SELECT  car.state,car.lastUpdate,user.firstName,user.lastName,car.id,car.shipperId,car.uuid,car.make,car.model,car.year,car.releaseOption,carimage.url  FROM car  LEFT JOIN shipper on car.shipperId = shipper.id LEFT JOIN user on shipper.userId = user.id LEFT JOIN carimage  on carimage.carId=car.id and carimage.type=0 where car.shipperId=? and car.deleted = 0   group by  car.id order by car.lastUpdate DESC LIMIT ?,?;");
		
		}elseif($type == 1){
            //WareHouse
			$stmt = $this->con->prepare("SELECT  car.state,car.lastUpdate,user.firstName,user.lastName,car.id,car.shipperId,car.uuid,car.make,car.model,car.year,car.releaseOption,carimage.url  FROM car  LEFT JOIN shipper on car.shipperId = shipper.id LEFT JOIN user on shipper.userId = user.id LEFT JOIN carimage  on carimage.carId=car.id and carimage.type=0 where car.shipperId=? and (car.state=0 or car.state=1 or car.state=2 or car.state=3) and car.deleted = 0   group by  car.id order by car.lastUpdate DESC LIMIT ?,?;");
		
        }elseif($type == 2){
            //Dry Cargo
			$stmt = $this->con->prepare("SELECT  car.state,car.lastUpdate,user.firstName,user.lastName,car.id,car.shipperId,car.uuid,car.make,car.model,car.year,car.releaseOption,carimage.url  FROM car  LEFT JOIN shipper on car.shipperId = shipper.id LEFT JOIN user on shipper.userId = user.id LEFT JOIN carimage  on carimage.carId=car.id and carimage.type=0 where car.shipperId=? and (car.state=4 or car.state=5) and car.deleted = 0   group by  car.id order by car.lastUpdate DESC LIMIT ?,?;");
		
        }elseif($type == 3){
            //Fright in Transit
			$stmt = $this->con->prepare("SELECT  car.state,car.lastUpdate,user.firstName,user.lastName,car.id,car.shipperId,car.uuid,car.make,car.model,car.year,car.releaseOption,carimage.url  FROM car  LEFT JOIN shipper on car.shipperId = shipper.id LEFT JOIN user on shipper.userId = user.id LEFT JOIN carimage  on carimage.carId=car.id and carimage.type=0 where car.shipperId=? and (car.state=6 or car.state=7) and car.deleted = 0   group by  car.id order by car.lastUpdate DESC LIMIT ?,?;");
		
        }elseif($type == 4){
            //Sent For Payment
			$stmt = $this->con->prepare("SELECT  car.state,car.lastUpdate,user.firstName,user.lastName,car.id,car.shipperId,car.uuid,car.make,car.model,car.year,car.releaseOption,carimage.url  FROM car  LEFT JOIN shipper on car.shipperId = shipper.id LEFT JOIN user on shipper.userId = user.id LEFT JOIN carimage  on carimage.carId=car.id and carimage.type=0 where car.shipperId=? and (car.state=8) and car.deleted = 0   group by  car.id order by car.lastUpdate DESC LIMIT ?,?;");
		
        }
        
        $stmt->bind_param("sss", $shipperId, $page, $itemsNumber);
        $stmt->execute();
		
        $stmt->bind_result($state,$lastUpdateCar,$firstName,$lastName,$id,$shipperId,$uuid,$make,$model,$year,$releaseOption,$url);

        $data = array();

        while ($stmt->fetch()) {

            $temp = array();
            $temp['id'] = $id;
			$temp['state'] = $state;
			$temp['lastUpdateCar'] = $lastUpdateCar;
			$temp['shipper_firstName'] = $this->getStringAsReq($firstName);
			$temp['shipper_lastName'] = $this->getStringAsReq($lastName);
			$temp['shipperId'] = $shipperId;
			$temp['uuid'] = $uuid;
			$temp['make'] = $make;
			$temp['model'] = $model;
			$temp['year'] = $year;
			$temp['releaseOption'] = $releaseOption;
			$temp['url'] = $url;
            array_push($data, $temp);
        }

        return $data;
    }

	
	
	 public function getAllCarsForVendorAccount($vendorId,$page,$itemsNumber,$type)
    {
		if($type == 0){
			$stmt = $this->con->prepare("SELECT  car.state,car.lastUpdate,user.firstName,user.lastName,car.id,car.shipperId,car.uuid,car.make,car.model,car.year,car.releaseOption,carimage.url  FROM car  LEFT JOIN shipper on car.shipperId = shipper.id LEFT JOIN user on shipper.userId = user.id LEFT JOIN carimage  on carimage.carId=car.id and carimage.type=0 where car.vendorId=? and car.deleted = 0   group by  car.id order by car.lastUpdate DESC LIMIT ?,?;");
		
		}elseif($type == 1){
            //WareHouse
			$stmt = $this->con->prepare("SELECT  car.state,car.lastUpdate,user.firstName,user.lastName,car.id,car.shipperId,car.uuid,car.make,car.model,car.year,car.releaseOption,carimage.url  FROM car  LEFT JOIN shipper on car.shipperId = shipper.id LEFT JOIN user on shipper.userId = user.id LEFT JOIN carimage  on carimage.carId=car.id and carimage.type=0 where car.vendorId=? and (car.state=0 or car.state=1 or car.state=2 or car.state=3) and car.deleted = 0   group by  car.id order by car.lastUpdate DESC LIMIT ?,?;");
		
        }elseif($type == 2){
            //Dry Cargo
			$stmt = $this->con->prepare("SELECT  car.state,car.lastUpdate,user.firstName,user.lastName,car.id,car.shipperId,car.uuid,car.make,car.model,car.year,car.releaseOption,carimage.url  FROM car  LEFT JOIN shipper on car.shipperId = shipper.id LEFT JOIN user on shipper.userId = user.id LEFT JOIN carimage  on carimage.carId=car.id and carimage.type=0 where car.vendorId=? and (car.state=4 or car.state=5) and car.deleted = 0   group by  car.id order by car.lastUpdate DESC LIMIT ?,?;");
		
        }elseif($type == 3){
            //Fright in Transit
			$stmt = $this->con->prepare("SELECT  car.state,car.lastUpdate,user.firstName,user.lastName,car.id,car.shipperId,car.uuid,car.make,car.model,car.year,car.releaseOption,carimage.url  FROM car  LEFT JOIN shipper on car.shipperId = shipper.id LEFT JOIN user on shipper.userId = user.id LEFT JOIN carimage  on carimage.carId=car.id and carimage.type=0 where car.vendorId=? and (car.state=6 or car.state=7) and car.deleted = 0   group by  car.id order by car.lastUpdate DESC LIMIT ?,?;");
		
        }elseif($type == 4){
            //Sent For Payment
			$stmt = $this->con->prepare("SELECT  car.state,car.lastUpdate,user.firstName,user.lastName,car.id,car.shipperId,car.uuid,car.make,car.model,car.year,car.releaseOption,carimage.url  FROM car  LEFT JOIN shipper on car.shipperId = shipper.id LEFT JOIN user on shipper.userId = user.id LEFT JOIN carimage  on carimage.carId=car.id and carimage.type=0 where car.vendorId=? and (car.state=8) and car.deleted = 0   group by  car.id order by car.lastUpdate DESC LIMIT ?,?;");
		
        }
        
        $stmt->bind_param("sss", $vendorId, $page, $itemsNumber);
        $stmt->execute();
		
        $stmt->bind_result($state,$lastUpdateCar,$firstName,$lastName,$id,$shipperId,$uuid,$make,$model,$year,$releaseOption,$url);

        $data = array();

        while ($stmt->fetch()) {

            $temp = array();
            $temp['id'] = $id;
			$temp['state'] = $state;
			$temp['lastUpdateCar'] = $lastUpdateCar;
			$temp['shipper_firstName'] = $this->getStringAsReq($firstName);
			$temp['shipper_lastName'] = $this->getStringAsReq($lastName);
			$temp['shipperId'] = $shipperId;
			$temp['uuid'] = $uuid;
			$temp['make'] = $make;
			$temp['model'] = $model;
			$temp['year'] = $year;
			$temp['releaseOption'] = $releaseOption;
			$temp['url'] = $url;
            array_push($data, $temp);
        }

        return $data;
    }

	
	 public function getAllCarsForCustomerAccount($customerId,$page,$itemsNumber,$type)
    {
		if($type == 0){
			$stmt = $this->con->prepare("SELECT  car.state,car.lastUpdate,user.firstName,user.lastName,car.id,car.shipperId,car.uuid,car.make,car.model,car.year,car.releaseOption,carimage.url  FROM car  LEFT JOIN shipper on car.shipperId = shipper.id LEFT JOIN user on shipper.userId = user.id LEFT JOIN carimage  on carimage.carId=car.id and carimage.type=0 where car.customerId=? and car.deleted = 0   group by  car.id order by car.lastUpdate DESC LIMIT ?,?;");
		
		}elseif($type == 1){
            //WareHouse
			$stmt = $this->con->prepare("SELECT  car.state,car.lastUpdate,user.firstName,user.lastName,car.id,car.shipperId,car.uuid,car.make,car.model,car.year,car.releaseOption,carimage.url  FROM car  LEFT JOIN shipper on car.shipperId = shipper.id LEFT JOIN user on shipper.userId = user.id LEFT JOIN carimage  on carimage.carId=car.id and carimage.type=0 where car.customerId=? and (car.state=0 or car.state=1 or car.state=2 or car.state=3) and car.deleted = 0   group by  car.id order by car.lastUpdate DESC LIMIT ?,?;");
		
        }elseif($type == 2){
            //Dry Cargo
			$stmt = $this->con->prepare("SELECT  car.state,car.lastUpdate,user.firstName,user.lastName,car.id,car.shipperId,car.uuid,car.make,car.model,car.year,car.releaseOption,carimage.url  FROM car  LEFT JOIN shipper on car.shipperId = shipper.id LEFT JOIN user on shipper.userId = user.id LEFT JOIN carimage  on carimage.carId=car.id and carimage.type=0 where car.customerId=? and (car.state=4 or car.state=5) and car.deleted = 0   group by  car.id order by car.lastUpdate DESC LIMIT ?,?;");
		
        }elseif($type == 3){
            //Fright in Transit
			$stmt = $this->con->prepare("SELECT  car.state,car.lastUpdate,user.firstName,user.lastName,car.id,car.shipperId,car.uuid,car.make,car.model,car.year,car.releaseOption,carimage.url  FROM car  LEFT JOIN shipper on car.shipperId = shipper.id LEFT JOIN user on shipper.userId = user.id LEFT JOIN carimage  on carimage.carId=car.id and carimage.type=0 where car.customerId=? and (car.state=6 or car.state=7) and car.deleted = 0   group by  car.id order by car.lastUpdate DESC LIMIT ?,?;");
		
        }elseif($type == 4){
            //Sent For Payment
			$stmt = $this->con->prepare("SELECT  car.state,car.lastUpdate,user.firstName,user.lastName,car.id,car.shipperId,car.uuid,car.make,car.model,car.year,car.releaseOption,carimage.url  FROM car  LEFT JOIN shipper on car.shipperId = shipper.id LEFT JOIN user on shipper.userId = user.id LEFT JOIN carimage  on carimage.carId=car.id and carimage.type=0 where car.customerId=? and (car.state=8) and car.deleted = 0   group by  car.id order by car.lastUpdate DESC LIMIT ?,?;");
		
        }
        
        $stmt->bind_param("sss", $customerId, $page, $itemsNumber);
        $stmt->execute();
		
        $stmt->bind_result($state,$lastUpdateCar,$firstName,$lastName,$id,$shipperId,$uuid,$make,$model,$year,$releaseOption,$url);

        $data = array();

        while ($stmt->fetch()) {

            $temp = array();
            $temp['id'] = $id;
			$temp['state'] = $state;
			$temp['lastUpdateCar'] = $lastUpdateCar;
			$temp['shipper_firstName'] = $this->getStringAsReq($firstName);
			$temp['shipper_lastName'] = $this->getStringAsReq($lastName);
			$temp['shipperId'] = $shipperId;
			$temp['uuid'] = $uuid;
			$temp['make'] = $make;
			$temp['model'] = $model;
			$temp['year'] = $year;
			$temp['releaseOption'] = $releaseOption;
			$temp['url'] = $url;
            array_push($data, $temp);
        }

        return $data;
    }

	
	
	 public function getAllCarsForConsigneeAccount($consigneeId,$page,$itemsNumber,$type)
    {
		if($type == 0){
			$stmt = $this->con->prepare("SELECT  car.state,car.lastUpdate,user.firstName,user.lastName,car.id,car.shipperId,car.uuid,car.make,car.model,car.year,car.releaseOption,carimage.url  FROM car  LEFT JOIN shipper on car.shipperId = shipper.id LEFT JOIN user on shipper.userId = user.id LEFT JOIN carimage  on carimage.carId=car.id and carimage.type=0 where car.consigneeId=? and car.deleted = 0   group by  car.id order by car.lastUpdate DESC LIMIT ?,?;");
		
		}elseif($type == 1){
            //WareHouse
			$stmt = $this->con->prepare("SELECT  car.state,car.lastUpdate,user.firstName,user.lastName,car.id,car.shipperId,car.uuid,car.make,car.model,car.year,car.releaseOption,carimage.url  FROM car  LEFT JOIN shipper on car.shipperId = shipper.id LEFT JOIN user on shipper.userId = user.id LEFT JOIN carimage  on carimage.carId=car.id and carimage.type=0 where car.consigneeId=? and (car.state=0 or car.state=1 or car.state=2 or car.state=3) and car.deleted = 0   group by  car.id order by car.lastUpdate DESC LIMIT ?,?;");
		
        }elseif($type == 2){
            //Dry Cargo
			$stmt = $this->con->prepare("SELECT  car.state,car.lastUpdate,user.firstName,user.lastName,car.id,car.shipperId,car.uuid,car.make,car.model,car.year,car.releaseOption,carimage.url  FROM car  LEFT JOIN shipper on car.shipperId = shipper.id LEFT JOIN user on shipper.userId = user.id LEFT JOIN carimage  on carimage.carId=car.id and carimage.type=0 where car.consigneeId=? and (car.state=4 or car.state=5) and car.deleted = 0   group by  car.id order by car.lastUpdate DESC LIMIT ?,?;");
		
        }elseif($type == 3){
            //Fright in Transit
			$stmt = $this->con->prepare("SELECT  car.state,car.lastUpdate,user.firstName,user.lastName,car.id,car.shipperId,car.uuid,car.make,car.model,car.year,car.releaseOption,carimage.url  FROM car  LEFT JOIN shipper on car.shipperId = shipper.id LEFT JOIN user on shipper.userId = user.id LEFT JOIN carimage  on carimage.carId=car.id and carimage.type=0 where car.consigneeId=? and (car.state=6 or car.state=7) and car.deleted = 0   group by  car.id order by car.lastUpdate DESC LIMIT ?,?;");
		
        }elseif($type == 4){
            //Sent For Payment
			$stmt = $this->con->prepare("SELECT  car.state,car.lastUpdate,user.firstName,user.lastName,car.id,car.shipperId,car.uuid,car.make,car.model,car.year,car.releaseOption,carimage.url  FROM car  LEFT JOIN shipper on car.shipperId = shipper.id LEFT JOIN user on shipper.userId = user.id LEFT JOIN carimage  on carimage.carId=car.id and carimage.type=0 where car.consigneeId=? and (car.state=8) and car.deleted = 0   group by  car.id order by car.lastUpdate DESC LIMIT ?,?;");
		
        }
        
        $stmt->bind_param("sss", $consigneeId, $page, $itemsNumber);
        $stmt->execute();
		
        $stmt->bind_result($state,$lastUpdateCar,$firstName,$lastName,$id,$shipperId,$uuid,$make,$model,$year,$releaseOption,$url);

        $data = array();

        while ($stmt->fetch()) {

            $temp = array();
            $temp['id'] = $id;
			$temp['state'] = $state;
			$temp['lastUpdateCar'] = $lastUpdateCar;
			$temp['shipper_firstName'] = $this->getStringAsReq($firstName);
			$temp['shipper_lastName'] = $this->getStringAsReq($lastName);
			$temp['shipperId'] = $shipperId;
			$temp['uuid'] = $uuid;
			$temp['make'] = $make;
			$temp['model'] = $model;
			$temp['year'] = $year;
			$temp['releaseOption'] = $releaseOption;
			$temp['url'] = $url;
            array_push($data, $temp);
        }

        return $data;
    }

}